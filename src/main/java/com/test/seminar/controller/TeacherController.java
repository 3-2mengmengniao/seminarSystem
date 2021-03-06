package com.test.seminar.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.*;
import com.test.seminar.service.*;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    FileService fileService;

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
    public ResponseEntity<String> activatePost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,@RequestParam(value = "validation") String validation,Model model) {
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
        fileService.uploadStudentExcel(file,classId,courseId);
        return "redirect:/teacher/course/klassList?courseId="+courseId;
    }

    @RequestMapping(value="/course/info")
    public String courseInfo(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "teacher/course/info";
    }

    @RequestMapping(value="/course/create",method = GET)
    public String createCourse(Model model) { return "teacher/course/create"; }

    @RequestMapping(value="/course/seminar/create",method = GET)
    public String createSeminar(BigInteger courseId,Model model) {
        model.addAttribute("courseId",courseId);
        return "teacher/course/seminar/create";
    }

    @RequestMapping(value="/course",method = POST)
    @ResponseBody
    public ResponseEntity<String> createCoursePost(HttpServletRequest request,Model model,Course course) {
        HttpSession session = request.getSession();
        BigInteger teacherId=(BigInteger)session.getAttribute("id");
        course.setTeacherId(teacherId);
        System.out.println(course.getCourseName());
        courseService.insertCourse(course);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/klass/create",method = GET)
    public String createClass(BigInteger courseId,Model model) {
        model.addAttribute("courseId",courseId);
        return "teacher/course/createKlass";
    }

    @RequestMapping(value="/course/klass/create",method = POST)
    @ResponseBody
    public ResponseEntity<String> createClassPost(BigInteger courseId,Model model,CourseClass courseClass) {
        courseClass.setCourseId(courseId);
        courseClassService.insertCourseClass(courseClass);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/klass/{klassId}",method = DELETE)
    @ResponseBody
    public ResponseEntity<String> classDelete(@PathVariable BigInteger klassId, Model model) {
        courseClassService.deleteCourseClassByCourseClassId(klassId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/grade")
    public String groupScore(Model model) {
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
        List<Round> roundList= roundService.getRoundByCourseId(courseId);
        model.addAttribute("roundList",roundList);
        List<List<SeminarInfo>> seminarList = seminarService.getSeminarInfoByRoundList(roundList);
        model.addAttribute("seminarList",seminarList);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        List<CourseClass> courseClasses=courseClassService.getCourseClassByCourseId(courseId);
        model.addAttribute("courseClassList",courseClasses);
        return "teacher/course/seminarList";
    }

    @RequestMapping(value="/course/roundSetting")
    public String roundSetting(BigInteger courseId,BigInteger roundId,Model model) {
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

    @RequestMapping(value="/course/teamList")
    public String teams(BigInteger courseId,Model model) {
        model.addAttribute("courseId",courseId);
        List<Team> teamList= teamService.getTeamByCourseId(courseId);
        model.addAttribute("teamList",teamList);
        List<List<Student>> studentList=new LinkedList<List<Student>>();
        List<Student> leaderList=new ArrayList();
        List<CourseClass> classList=new ArrayList<>();
        for( int i = 0 ; i < teamList.size() ; i++) {
            BigInteger teamId=teamList.get(i).getId();
            List<Student> teamStudents= studentService.getStudentByTeamId(teamId);
            studentList.add(teamStudents);
            Student leader=studentService.getStudentByStudentId(teamList.get(i).getLeaderId());
            leaderList.add(leader);
            BigInteger classId=teamList.get(i).getClassId();
            CourseClass teamClass=courseClassService.getCourseClassByCourseClassId(classId);
            classList.add(teamClass);
        }
        model.addAttribute("studentList",studentList);
        model.addAttribute("leaderList",leaderList);
        model.addAttribute("classList",classList);
        return "teacher/course/teamList";
    }

    @RequestMapping(value="/course/seminar/info")
    public String seminarInfo(BigInteger courseId, BigInteger classId,BigInteger seminarId, Model model) {
            SeminarControl seminarControl = seminarService.getSemniarControlByClassIdAndSeminarInfoId(classId, seminarId);
            SeminarInfo seminarInfo=seminarService.getSeminarInfoBySeminarInfoId(seminarId);
            model.addAttribute("seminarInfo",seminarInfo);
            BigInteger roundId=seminarInfo.getRoundId();
            Round round=roundService.getRoundByRoundId(roundId);
            model.addAttribute("round",round);
            Course course=courseService.getCourseByCourseId(courseId);
            model.addAttribute("course",course);
            model.addAttribute("classId",classId);
        model.addAttribute("status",seminarControl.getSeminarStatus());
        return "teacher/course/seminar/info";
    }

    @RequestMapping(value="/course/seminar/enrollment")
    public String enrollmentInfo(HttpServletRequest request,BigInteger courseId, BigInteger classId,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSemniarControlByClassIdAndSeminarInfoId(classId, seminarId);
        SeminarInfo seminarInfo=seminarService.getSeminarInfoBySeminarInfoId(seminarId);
        model.addAttribute("seminarInfo",seminarInfo);
        BigInteger roundId=seminarInfo.getRoundId();
        Round round=roundService.getRoundByRoundId(roundId);
        model.addAttribute("round",round);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        model.addAttribute("classId",classId);
        model.addAttribute("status",seminarControl.getSeminarStatus());
        return "teacher/course/seminar/enrollment";
    }

    @RequestMapping(value="/course/seminar/report")
    public String report(HttpServletRequest request,BigInteger courseId, BigInteger classId,BigInteger seminarId, Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        SeminarInfo seminarInfo=seminarService.getSeminarInfoBySeminarInfoId(seminarId);
        model.addAttribute("seminarInfo",seminarInfo);
        model.addAttribute("course",course);
        model.addAttribute("classId",classId);
        model.addAttribute("seminarId",seminarId);
        return "teacher/course/seminar/report";
    }

    @RequestMapping(value="/course/seminar/score")
    public String seminarScore(HttpServletRequest request,BigInteger courseId, BigInteger classId,BigInteger seminarId, Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        SeminarInfo seminarInfo=seminarService.getSeminarInfoBySeminarInfoId(seminarId);
        model.addAttribute("seminarInfo",seminarInfo);
        model.addAttribute("course",course);
        model.addAttribute("classId",classId);
        model.addAttribute("seminarId",seminarId);
        return "teacher/course/seminar/score";
    }

    @RequestMapping(value="/report_download")
    public String reportDownload(Model model) {
        return "teacher/report_download";
    }

    @RequestMapping(value="/report_score")
    public String reportScore(Model model) {
        return "teacher/report_score";
    }

    @RequestMapping(value = "/activate",method = GET)
    public String activate(Model model) { return "teacher/activate"; }

    @RequestMapping(value = "/message",method = GET)
    public String message(Model model) { return "teacher/message"; }

    @RequestMapping(value="course/shareSettings")
    public String shareSettings(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "teacher/course/shareSettings";
    }

}
