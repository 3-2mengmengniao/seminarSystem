package com.test.seminar.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.*;
import com.test.seminar.entity.strategy.impl.ConflictCourseStrategy;
import com.test.seminar.entity.strategy.impl.CourseMemberLimitStrategy;
import com.test.seminar.entity.strategy.impl.MemberLimitStrategy;
import com.test.seminar.service.*;
import javafx.util.Pair;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hatake
 * @date 2018/11/20
 */

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    CourseService courseService;

    @Autowired
    RoundService roundService;

    @Autowired
    SeminarService seminarService;

    @Autowired
    CourseClassService courseClassService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    TeamService teamService;

    @Autowired
    StudentService studentService;

    @Autowired
    RunSeminarService rundSeminarService;

//    @Autowired
//    FileService fileService;

    @RequestMapping(value = "/index")
    public String home(Model model,HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Teacher teacher = teacherService.getTeacherByAccount(user.getUsername());
        model.addAttribute(teacher);
        session.setAttribute("id",teacher.getId());
        if(teacher.getActive()==0)
        {
            return "teacher/activate";
        }
        return "teacher/index";
    }

    @RequestMapping(value="/courseList",method = GET)
    public String courses(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByTeacherId(teacherId);
        model.addAttribute("courseList",courseList);
        return "teacher/courseList";
    }

    @RequestMapping(value="/course/{courseId}",method = DELETE)
    @ResponseBody
    public ResponseEntity<String> courseDelete(@PathVariable BigInteger courseId, Model model) {
        courseService.deleteCourseByCourseId(courseId);

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/setting",method = GET)
    public String security(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
        model.addAttribute("teacher",teacher);
        return "teacher/setting";
    }

    @RequestMapping(value = "/modifyEmail", method = POST)
    @ResponseBody
    public ResponseEntity<String> emailModifyPost(HttpServletRequest request, @RequestParam(value = "email") String email, @RequestParam(value = "validation") String validation, Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
        teacher.setEmail(email);
        teacherService.updateTeacherByTeacherId(teacher);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value = "/modifyPassword", method = GET)
    public String modifyPassword(Model model) {
        return "teacher/modifyPassword";
    }

    @RequestMapping(value = "/modifyEmail", method = GET)
    public String emailModify(Model model) {
        return "teacher/modifyEmail";
    }

    @RequestMapping(value = "/modifyPassword", method = POST)
    @ResponseBody
    public ResponseEntity<String> valiPswPost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,@RequestParam(value = "confirmPsw") String confirmPsw, @RequestParam(value = "validation") String validation,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
        teacher.setPassword(newPsw);
        teacherService.updateTeacherByTeacherId(teacher);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value = "/activate", method = POST)
    @ResponseBody
    public ResponseEntity<String> activatePost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        Teacher teacher=teacherService.getTeacherByTeacherId(teacherId);
        teacher.setPassword(newPsw);
        teacher.setActive(1);
        teacherService.updateTeacherByTeacherId(teacher);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/klassList",method = GET)
    public String classInfo(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        List<CourseClass> courseClasses=courseClassService.getCourseClassByCourseId(courseId);
        model.addAttribute("courseClassList",courseClasses);
        model.addAttribute("courseId",courseId);
        return "teacher/course/klassList";
    }


    @RequestMapping(value="/course/klassList",method = POST)
    public String classInfoPost(BigInteger courseId, BigInteger classId, MultipartFile file) {
        System.out.println(file);
        courseClassService.uploadStudentExcel(file,classId,courseId);
        return "redirect:/teacher/course/klassList?courseId="+courseId;
    }

    @RequestMapping(value="/course/info")
    public String courseInfo(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "teacher/course/info";
    }

    @RequestMapping(value="/course/create",method = GET)
    public String createCourse(Model model) {
        List<Course> courseList=courseService.getAllCourse();
        model.addAttribute("courseList",courseList);
        return "teacher/course/create";
    }

    @RequestMapping(value="/course/seminar/create",method = GET)
    public String createSeminar(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "teacher/course/seminar/create";
    }

    @RequestMapping(value="/course/seminar/setting",method = GET)
    public String seminarSetting(BigInteger courseId,BigInteger seminarId,Model model) {
        SeminarInfo seminarInfo=seminarService.getSeminarInfoBySeminarInfoId(seminarId);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        model.addAttribute("seminar",seminarInfo);
        return "teacher/course/seminar/setting";
    }

    @RequestMapping(value="/message/handle",method = POST)
    @ResponseBody
    public ResponseEntity<String> applicationHandle(HttpServletRequest request,Model model) {
        BigInteger applicationId=new BigInteger((String)request.getParameter("applicationId"));
        String type=request.getParameter("type");
        Integer status=Integer.valueOf(request.getParameter("status"));
        boolean isTeam=("team".equals(type));
        boolean isSeminar=("seminar".equals(type));
        boolean isVali=("validate".equals(type));
        if(status==0) {
            if(isTeam) {
                ShareTeamApplication shareTeamApplication=courseService.getShareTeamApplicationByApplicationId(applicationId);
                shareTeamApplication.setStatus(0);
                teamService.updateShareTeamApplication(shareTeamApplication);
                return new ResponseEntity<>("", HttpStatus.OK);
            }
            if(isSeminar){
                ShareSeminarApplication shareSeminarApplication=courseService.getShareSeminarApplicationByApplicationId(applicationId);
                shareSeminarApplication.setStatus(0);
                seminarService.updateShareSeminarApplication(shareSeminarApplication);
                return new ResponseEntity<>("", HttpStatus.OK);
            }
            if(isVali){
                TeamValidApplication teamValidApplication=teamService.getTeamValidApplicationByApplicationId(applicationId);
                teamValidApplication.setStatus(1);
                teamService.updateTeamValidApplication(teamValidApplication);
                return new ResponseEntity<>("", HttpStatus.OK);
            }

        }
        else if(isTeam||isSeminar)
        {
            BigInteger courseId=new BigInteger(request.getParameter("courseId"));
            Course course=courseService.getCourseByCourseId(courseId);
            if(isTeam&&null!=course.getTeamMainCourseId())
            {
                return new ResponseEntity<>("", HttpStatus.CONFLICT);
            }
            if(isSeminar&&null!=course.getSeminarMainCourseId())
            {
                return new ResponseEntity<>("", HttpStatus.CONFLICT);
            }
            if(isTeam)
            {
                ShareTeamApplication shareTeamApplication=courseService.getShareTeamApplicationByApplicationId(applicationId);
                shareTeamApplication.setStatus(1);
                teamService.updateShareTeamApplication(shareTeamApplication);
                return new ResponseEntity<>("", HttpStatus.OK);
            }
            if (isSeminar) {
                ShareSeminarApplication shareSeminarApplication=courseService.getShareSeminarApplicationByApplicationId(applicationId);
                shareSeminarApplication.setStatus(1);
                seminarService.updateShareSeminarApplication(shareSeminarApplication);
                return new ResponseEntity<>("", HttpStatus.OK);

            }

        }
        else if(isVali){
            TeamValidApplication teamValidApplication=teamService.getTeamValidApplicationByApplicationId(applicationId);
            teamValidApplication.setStatus(1);
            teamService.updateTeamValidApplication(teamValidApplication);
            return new ResponseEntity<>("", HttpStatus.OK);
        }
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/course/application/add",method = POST)
    @ResponseBody
    public ResponseEntity<String> applicationAdd(HttpServletRequest request,Model model) {
        BigInteger mainCourseId=new BigInteger(request.getParameter("mainCourseId"));
        BigInteger subCourseId=new BigInteger(request.getParameter("subCourseId"));
        Integer type=Integer.valueOf(request.getParameter("type"));
        Course subCourse=courseService.getCourseByCourseId(subCourseId);
        if(type==1)
        {
            courseService.insertShareSeminarApplication(mainCourseId,subCourseId,subCourse.getTeacherId());
        }
        else if(type==2)
        {
            courseService.insertShareTeamApplication(mainCourseId,subCourseId,subCourse.getTeacherId());

        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/application/cancel",method = POST)
    @ResponseBody
    public ResponseEntity<String> applicationCancel(HttpServletRequest request,Model model) {
        BigInteger subCourseId=new BigInteger(request.getParameter("courseId"));
        String type=request.getParameter("type");
        Course subCourse=courseService.getCourseByCourseId(subCourseId);
        if("team".equals(type))
        {
            teamService.cancelTeamShare(subCourse);
        }
        else if("seminar".equals(type))
        {
            seminarService.cancelSeminarShare(subCourse);

        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }


    @RequestMapping(value="/course",method = POST)
    @ResponseBody
    public ResponseEntity<String> createCoursePost(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        System.out.println(request.getParameter("courseName"));
        Course course=new Course();
        course.setCourseName(request.getParameter("courseName"));
        course.setIntroduction(request.getParameter("introduction"));
        course.setPresentationPercentage(Integer.valueOf(request.getParameter("presentationPercentage")));
        course.setQuestionPercentage(Integer.valueOf(request.getParameter("questionPercentage")));
        course.setReportPercentage(Integer.valueOf(request.getParameter("reportPercentage")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            course.setTeamEndTime(sdf.parse(request.getParameter("teamEndTime")));
            course.setTeamStartTime(sdf.parse(request.getParameter("teamStartTime")));
        }catch(Exception e)
        {
            System.out.println("时间格式出错！");
        }
        MemberLimitStrategy thisCourse=new MemberLimitStrategy();
        thisCourse.setMinMember(Integer.valueOf(request.getParameter("minTeamMember")));
        thisCourse.setMaxMember(Integer.valueOf(request.getParameter("maxTeamMember")));
        List<CourseMemberLimitStrategy> courseMemberLimitStrategyList=new ArrayList<>();
        String members=request.getParameter("members");
        JSONArray myArray=JSONArray.fromObject(members);
        for(int i=0;i<myArray.size();i++){
            JSONArray secondArray=(JSONArray)myArray.get(i);
            CourseMemberLimitStrategy optionCourse=new CourseMemberLimitStrategy();
            BigInteger cid=new BigInteger((String)secondArray.get(0));
            optionCourse.setCourseId(cid);
            optionCourse.setMaxMember( Integer.valueOf((String)secondArray.get(1)));
            optionCourse.setMinMember( Integer.valueOf((String)secondArray.get(2)));
            courseMemberLimitStrategyList.add(optionCourse);
        }
        List<ConflictCourseStrategy> conflictCourseStrategyArrayList=new ArrayList<>();
        String conflicts=request.getParameter("conflicts");
        JSONArray conflictsArray=JSONArray.fromObject(conflicts);
        for(int i=0;i<conflictsArray.size();i++){
            JSONArray secondArray=(JSONArray)conflictsArray.get(i);
            ConflictCourseStrategy conflictCourse=new ConflictCourseStrategy();
            List<BigInteger> courseIdList=new ArrayList<>();
            for(int j=0;j<secondArray.size();j++) {
                String tmp=(String)secondArray.get(j);
                BigInteger cid=new BigInteger(tmp);
                courseIdList.add(cid);
            }
            conflictCourse.setConflictCourseIdList(courseIdList);
            conflictCourseStrategyArrayList.add(conflictCourse);
        }
        Integer choose=Integer.valueOf(request.getParameter("choose"));
        courseService.insertCourse(course,teacherId,conflictCourseStrategyArrayList,courseMemberLimitStrategyList,thisCourse,choose);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/klass/create",method = GET)
    public String createClass(BigInteger courseId,Model model) {
        model.addAttribute("courseId",courseId);
        return "teacher/course/createKlass";
    }

    @RequestMapping(value="/course/klass/create",method = POST)
    @ResponseBody
    public ResponseEntity<String> createClassPost(BigInteger courseId,Model model,CourseClass courseClass,MultipartFile file) {
        courseClassService.insertCourseClass(courseClass,courseId,file);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/seminar/create",method = PUT)
    @ResponseBody
    public ResponseEntity<String> createSeminarPost(BigInteger courseId,Model model,SeminarInfo seminarInfo,
                                                    String seminarVisible,Integer roundSerial) {
        if(seminarVisible.equals("on"))
        {
            seminarInfo.setVisible(1);
        }
        else{
            seminarInfo.setVisible(0);
        }
        System.out.println(roundSerial);
        seminarService.insertSeminarInfo(seminarInfo,courseId,roundSerial);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/seminar/setting",method = PUT)
    @ResponseBody
    public ResponseEntity<String> seminarSettingPost(BigInteger seminarId,Model model,SeminarInfo seminarInfo,
                                                     String seminarVisible,Integer roundSerial,BigInteger courseId) {
        SeminarInfo seminarInfoOld=seminarService.getSeminarInfoBySeminarInfoId(seminarId);
        if(seminarVisible.equals("on"))
        {
            seminarInfoOld.setVisible(1);
        }
        else{
            seminarInfoOld.setVisible(0);
        }
        seminarInfoOld.setMaxGroup(seminarInfo.getMaxGroup());
        seminarInfoOld.setRegistrationEndTime(seminarInfo.getRegistrationEndTime());
        seminarInfoOld.setRegistrationStartTime(seminarInfo.getRegistrationStartTime());
        seminarInfoOld.setSeminarSerial(seminarInfo.getSeminarSerial());
        seminarService.deleteSeminarInfoBySeminarInfoId(seminarInfoOld.getId());
        seminarService.insertSeminarInfo(seminarInfoOld,courseId,roundSerial);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/klass/{klassId}",method = DELETE)
    @ResponseBody
    public ResponseEntity<String> classDelete(@PathVariable BigInteger klassId, Model model) {
        courseClassService.deleteCourseClassByCourseClassId(klassId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/grade")
    public String groupScore(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        List<Team> teamList=teamService.getTeamByCourseId(courseId);
        model.addAttribute("teamList",teamList);
        List<Round> roundList=roundService.getRoundByCourseId(courseId);
        model.addAttribute("roundList",roundList);
        return "teacher/course/grade";
    }

    @RequestMapping(value="/seminars")
    public String seminars(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByTeacherId(teacherId);
        model.addAttribute("courseList",courseList);
        return "teacher/seminars";
    }

    @RequestMapping(value="/course/seminarList")
    public String courseSeminar(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        List<Round> roundList= course.getRoundList();
        model.addAttribute("roundList",roundList);
        List<CourseClass> courseClasses=courseClassService.getCourseClassByCourseId(courseId);
        model.addAttribute("courseClassList",courseClasses);
        return "teacher/course/seminarList";
    }

    @RequestMapping(value="/course/roundSetting",method = GET)
    public String roundSetting(BigInteger roundId,BigInteger courseId,Model model) {
        Round round=roundService.getRoundByRoundId(roundId);
        model.addAttribute("round",round);
        List<SeminarInfo> seminarList = seminarService.getSeminarInfoByRoundId(roundId);
        model.addAttribute("seminarList",seminarList);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        List<CourseClass> courseClasses=courseClassService.getCourseClassByCourseId(courseId);
        model.addAttribute("courseClassList",courseClasses);
        return "teacher/course/roundSetting";
    }

    @RequestMapping(value="/course/roundSetting",method = PATCH)
    @ResponseBody
    public ResponseEntity<String> roundSettingPost(HttpServletRequest request,Model model) {
        Round round=roundService.getRoundByRoundId(new BigInteger(request.getParameter("roundId")));
        round.setPresentationScoreMethod(Integer.valueOf(request.getParameter("presentationScoreMethod")));
        round.setQuestionScoreMethod(Integer.valueOf(request.getParameter("questionScoreMethod")));
        round.setReportScoreMethod(Integer.valueOf(request.getParameter("reportScoreMethod")));
        String data=request.getParameter("enrollment");
        JSONArray myArray=JSONArray.fromObject(data);
        for(int i=0;i<myArray.size();i++){
            String tmp=(String) myArray.get(i);
        }
        roundService.updateRound(round);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/teamList")
    public String teams(BigInteger courseId,Model model) {
        model.addAttribute("courseId",courseId);
        Pair<List<Team>,List<Student>> teamPair= teamService.getTeam(courseId);
        List<Team> teamList=teamPair.getKey();
        List<Student> studentNoTeamList=teamPair.getValue();
        model.addAttribute("teamList",teamList);
        model.addAttribute("studentNoTeamList",studentNoTeamList);
        return "teacher/course/teamList";
    }

    @RequestMapping(value="/course/seminar/info")
    public String seminarInfo(BigInteger classId,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSeminarControlByClassIdAndSeminarInfoId(classId, seminarId);
        model.addAttribute("seminarControl",seminarControl);
        return "teacher/course/seminar/info";
    }



    @RequestMapping(value="/course/seminar/enrollList")
    public String enrollmentInfo(BigInteger seminarId, Model model) {
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        return "teacher/course/seminar/enrollList";
    }

    @RequestMapping(value="/course/seminar/report")
    public String report(BigInteger seminarId, Model model) {
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        return "teacher/course/seminar/report";
    }

    @RequestMapping(value="/course/seminar/score")
    public String seminarScore(BigInteger seminarId, Model model) {
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        List<SeminarScore> seminarScoreList=seminarService.getSeminarScoreBySeminarControlId(seminarId);
        System.out.println(seminarId);
        model.addAttribute("seminarScoreList",seminarScoreList);
        return "teacher/course/seminar/score";
    }

    @RequestMapping(value="/course/seminar/presentationScore",method = POST)
    public String presentationScore(BigInteger presentationId, Model model) {



        return "teacher/course/seminar/score";
    }

    @RequestMapping(value = "/activate",method = GET)
    public String activate(Model model) { return "teacher/activate"; }

    @RequestMapping(value = "/message",method = GET)
    public String message(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        List<TeamValidApplication> teamValidApplicationList=teamService.getTeamValidApplicationByTeacherId(teacherId);
        List<ShareTeamApplication> shareTeamApplicationList=courseService.getShareTeamApplicationBySubCourseTeacherId(teacherId);
        List<ShareSeminarApplication> shareSeminarApplicationList=courseService.getShareSeminarApplicationBySubCourseTeacherId(teacherId);
        model.addAttribute("teamValidApplicationList",teamValidApplicationList);
        model.addAttribute("shareTeamApplicationList",shareTeamApplicationList);
        model.addAttribute("shareSeminarApplicationList",shareSeminarApplicationList);
        return "teacher/message";
    }

    @RequestMapping(value = "/course/seminar/report_deadline",method = GET)
    public String deadline(BigInteger seminarId,Model model) {
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        return "teacher/course/seminar/report_deadline";
    }

    @RequestMapping(value="course/shareSettings")
    public String shareSettings(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        if(course.getSeminarMainCourseId()!=null)
        {
            model.addAttribute("seminarMainCourse",courseService.getCourseByCourseId(course.getSeminarMainCourseId()));
        }
        if(course.getTeamMainCourseId()!=null)
        {
            model.addAttribute("teamMainCourse",courseService.getCourseByCourseId(course.getTeamMainCourseId()));
        }
        return "teacher/course/shareSettings";
    }

    @RequestMapping(value="course/addShare")
    public String addShare(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("myCourse",course);
        List<Course> courseList=courseService.getAllCourse();
        model.addAttribute("courseList",courseList);
        return "teacher/course/addShare";
    }

}
