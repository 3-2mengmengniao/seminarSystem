package com.test.seminar.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.*;
import com.test.seminar.service.*;
import javafx.util.Pair;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hatake
 * @date 2018/11/20
 */


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    CourseService courseService;

    @Autowired
    RoundService roundService;

    @Autowired
    SeminarService seminarService;

    @Autowired
    CourseClassService courseClassService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/index")
    public String home(Model model,HttpSession session) {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Student student = studentService.getStudentByAccount(user.getUsername());
        model.addAttribute(student);
        session.setAttribute("id",student.getId());
        if(student.getActive()==0)
        {
            return "student/activate";
        }
        return "student/index";
    }


    @RequestMapping(value = "/courseList", method = GET)
    public String courses(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByStudentId(studentId);
        model.addAttribute("courseList",courseList);
        return "student/courseList";
    }

    @RequestMapping(value = "/setting", method = GET)
    public String security(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Student student=studentService.getStudentByStudentId(studentId);
        model.addAttribute("student",student);
        return "student/setting";
    }

    @RequestMapping(value = "/modifyEmail", method = POST)
    @ResponseBody
    public ResponseEntity<String> emailModifyPost(HttpServletRequest request, @RequestParam(value = "email") String email, @RequestParam(value = "validation") String validation, Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Student student=studentService.getStudentByStudentId(studentId);
        student.setEmail(email);
        studentService.updateStudentByStudent(student);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value = "/modifyPassword", method = GET)
    public String modifyPassword(Model model) {
        return "student/modifyPassword";
    }

    @RequestMapping(value = "/modifyEmail", method = GET)
    public String emailModify(Model model) {
        return "student/modifyEmail";
    }

    @RequestMapping(value = "/modifyPassword", method = POST)
    @ResponseBody
    public ResponseEntity<String> valiPswPost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,@RequestParam(value = "confirmPsw") String confirmPsw, @RequestParam(value = "validation") String validation,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Student student=studentService.getStudentByStudentId(studentId);
        student.setPassword(newPsw);
        studentService.updateStudentByStudent(student);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value = "/activate", method = POST)
    @ResponseBody
    public ResponseEntity<String> activatePost(HttpServletRequest request,@RequestParam(value = "newPsw") String newPsw,@RequestParam(value = "email") String email,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Student student=studentService.getStudentByStudentId(studentId);
        student.setPassword(newPsw);
        student.setEmail(email);
        student.setActive(1);
        studentService.updateStudentByStudent(student);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value = "/seminars")
    public String seminars(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        List<Course> courseList= courseService.getCourseByStudentId(studentId);
        model.addAttribute("courseList",courseList);
        return "student/seminars";
    }

    @RequestMapping(value = "/course/seminarList")
    public String courseSeminar(BigInteger courseId, HttpServletRequest request,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        List<Round> roundList= course.getRoundList();
        model.addAttribute("roundList",roundList);
        System.out.println(roundList.get(0).getSeminarInfoList().size());
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        model.addAttribute("studentId",studentId);
        CourseClass myClass = courseClassService.getCourseClassByStudentIdAndCourseId(studentId, courseId);
        model.addAttribute("class",myClass);
        return "student/course/seminarList";
    }

    @RequestMapping(value = "/course/teams")
    public String teams(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        model.addAttribute("courseId",courseId);
        Pair<List<Team>,List<Student>> teamPair= teamService.getTeam(courseId);
        List<Team> teamList=teamPair.getKey();
        List<Student> studentNoTeamList=teamPair.getValue();
        model.addAttribute("teamList",teamList);
        model.addAttribute("studentNoTeamList",studentNoTeamList);
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,courseId);
        model.addAttribute("myTeam",team);
        int leader=0;
        if(team!=null && team.getLeader().getId().equals(studentId))
        {
            leader=1;
        }
        model.addAttribute("leader",leader);
        return "student/course/teams";
    }

    @RequestMapping(value="/course/team/disband",method = DELETE)
    @ResponseBody
    public ResponseEntity<String> disband(BigInteger teamId,Model model) {
        teamService.deleteTeamByTeamId(teamId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/team/delete",method = DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteMember(BigInteger teamId,BigInteger studentId,Model model) {
        teamService.deleteTeamMember(teamId,studentId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value = "/course/grade")
    public String groupScore(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,courseId);
        model.addAttribute("team",team);
        List<Round> roundList=roundService.getRoundByCourseId(courseId,team.getId());
        System.out.println(roundList.get(0).getRoundScoreList().size());
        model.addAttribute("roundList",roundList);
        return "student/course/grade";
    }

    @RequestMapping(value="/course/seminar/info",method = POST)
    public String seminarInfo(HttpServletRequest request,BigInteger classId,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSeminarControlByClassIdAndSeminarInfoId(classId, seminarId);
        model.addAttribute("seminarControl",seminarControl);
        List<Presentation> presentationList= seminarControl.getPresentationList();
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        boolean flag=false;
        int order=-1;
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,seminarControl.getCourseClass().getCourse().getId());
        for(int i=0;i<presentationList.size();i++)
        {
            if(presentationList.get(i)!=null){
                Team temp=presentationList.get(i).getTeam();
                if(temp.getId().equals(team.getId()))
                {
                    flag=true;
                    order=i;
                }
            }
        }
        model.addAttribute("myTeam",team);
        model.addAttribute("enrollment",flag);
        model.addAttribute("order",order);
        return "student/course/seminar/info";
    }

    @RequestMapping(value="/course/seminar/score",method = POST)
    public String seminarScore(HttpServletRequest request,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,seminarControl.getCourseClass().getCourse().getId());
        model.addAttribute("team",team);
        return "student/course/seminar/score";
    }

    @RequestMapping(value="/course/seminar/info/register",method = POST)
    @ResponseBody
    public ResponseEntity<String> seminarRegister(int order,BigInteger teamId,BigInteger seminarId, Model model) {
        seminarService.insertPresentation(order,seminarId,teamId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/seminar/enrollment",method = POST)
    public String enrollmentInfo(HttpServletRequest request,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        List<Presentation> presentationList= seminarControl.getPresentationList();
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        boolean flag=false;
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,seminarControl.getCourseClass().getCourse().getId());
        for(int i=0;i<presentationList.size();i++)
        {
            if(presentationList.get(i)!=null){
                Team temp=presentationList.get(i).getTeam();
                if(temp.getId().equals(team.getId()))
                {
                    flag=true;
                }
            }
        }
        model.addAttribute("team",team);
        model.addAttribute("enrollment",flag);
        return "student/course/seminar/enrollment";
    }

    @RequestMapping(value="/course/seminar/run",method = POST)
    public String seminarRun(HttpServletRequest request,BigInteger seminarId,Model model) {
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,seminarControl.getCourseClass().getCourse().getId());
        model.addAttribute("myTeam",team);
        model.addAttribute("studentId",studentId);
        return "student/course/seminar/run";
    }

    @RequestMapping(value="/course/seminar/PPT",method = POST)
    @ResponseBody
    public ResponseEntity<String> submitPPT(HttpServletRequest request,BigInteger seminarId, BigInteger teamId, MultipartFile file, Model model) {
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        System.out.println(file);
        try {
            seminarService.upLoadPPT(request,file, seminarId, teamId);
        }catch (IOException e)
        {
            return new ResponseEntity<>("", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/seminar/report",method = POST)
    @ResponseBody
    public ResponseEntity<String> submitReport(BigInteger seminarId, BigInteger teamId, MultipartFile file, Model model) {
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        System.out.println(file);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/info")
    public String courseInfo(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "student/course/info";
    }

    @RequestMapping(value = "/activate",method = GET)
    public String activate(Model model) { return "student/activate"; }

    @RequestMapping(value = "/course/createTeam", method = GET)
    public String createTeam(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Course course=courseService.getCourseByCourseId(courseId);
        List<CourseClass> courseClassList=courseClassService.getCourseClassByCourseId(courseId);
        Pair<List<Team>,List<Student>> teamPair= teamService.getTeam(courseId);
        List<Student> studentNoTeamList=teamPair.getValue();
        model.addAttribute("myId",studentId);
        model.addAttribute("course",course);
        model.addAttribute("noTeamStudentList",studentNoTeamList);
        model.addAttribute("classList",courseClassList);
        return "student/course/createTeam";
    }

    @RequestMapping(value="/course/team",method = POST)
    @ResponseBody
    public ResponseEntity<String> createTeam(BigInteger courseId,HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        BigInteger leaderId=(BigInteger)session.getAttribute("id");
        String data=request.getParameter("members");
        System.out.println(data);
        Team team=new Team();
        team.setTeamName(request.getParameter("teamName"));
        team.setStatus(0);
        BigInteger classId=new BigInteger(request.getParameter("classId"));
        team.setCourseClass(courseClassService.getCourseClassByCourseClassId(classId));
        team.setCourse(courseService.getCourseByCourseId(courseId));
        List<BigInteger> studentIdList=new ArrayList<>();
        studentIdList.add(leaderId);
        JSONArray myArray=JSONArray.fromObject(data);
        for(int i=0;i<myArray.size();i++){
            String id=(String) myArray.get(i);
            BigInteger studentId=new BigInteger(id);
            studentIdList.add(studentId);
        }
        team.setLeader(studentService.getStudentByStudentId(leaderId));
        Serial serial=new Serial();
        serial.setCourseClassSerial(team.getCourseClass().getClassSerial());
        team.setSerial(serial);
        teamService.insertTeam(team,studentIdList);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/student/course/team/add",method = POST)
    @ResponseBody
    public ResponseEntity<String> createTeam(HttpServletRequest request,Model model) {
        String data=request.getParameter("members");
        System.out.println(data);
        BigInteger teamId=new BigInteger(request.getParameter("teamId"));
        List<BigInteger> studentIdList=new ArrayList<>();
        JSONArray myArray=JSONArray.fromObject(data);
        for(int i=0;i<myArray.size();i++){
            String id=(String) myArray.get(i);
            BigInteger studentId=new BigInteger(id);
            studentIdList.add(studentId);
        }
        teamService.addTeamMember(teamId,studentIdList);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @RequestMapping(value="/course/myTeam")
    public String myTeam(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,courseId);
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        model.addAttribute("myTeam",team);
        model.addAttribute("myId",studentId);
        return "student/course/myTeam";
    }

    @RequestMapping(value = "/course/leaderTeam", method = GET)
    public String leaderTeam(HttpServletRequest request,BigInteger courseId,Model model) {
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,courseId);
        Pair<List<Team>,List<Student>> teamPair= teamService.getTeam(courseId);
        List<Student> studentNoTeamList=teamPair.getValue();
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        model.addAttribute("myTeam",team);
        model.addAttribute("myId",studentId);
        model.addAttribute("noTeamStudentList",studentNoTeamList);
        return "student/course/leaderTeam";
    }
}
