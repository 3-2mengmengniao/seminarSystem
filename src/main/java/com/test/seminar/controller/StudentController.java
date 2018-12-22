package com.test.seminar.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.test.seminar.entity.*;
import com.test.seminar.service.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        studentService.updateStudentByStudentId(student);
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
        studentService.updateStudentByStudentId(student);
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
        studentService.updateStudentByStudentId(student);
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
        List<Team> teamList= teamService.getTeamByCourseId(courseId);
        model.addAttribute("teamList",teamList);
//        List<List<Student>> studentList=new LinkedList<List<Student>>();
//        List<Student> leaderList=new ArrayList();
//        List<CourseClass> classList=new ArrayList<>();
//        for( int i = 0 ; i < teamList.size() ; i++) {
//            BigInteger teamId=teamList.get(i).getId();
//            List<Student> teamStudents= studentService.getStudentByTeamId(teamId);
//            Student leader=studentService.getStudentByStudentId(teamList.get(i).getLeaderId());
//            leaderList.add(leader);
//            studentList.add(teamStudents);
//            BigInteger classId=teamList.get(i).getClassId();
//            CourseClass teamClass=courseClassService.getCourseClassByCourseClassId(classId);
//            classList.add(teamClass);
//        }
//        model.addAttribute("studentList",studentList);
//        model.addAttribute("leaderList",leaderList);
//        model.addAttribute("classList",classList);
        return "student/course/teams";
    }

    @RequestMapping(value = "/course/grade")
    public String groupScore(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "student/course/grade";
    }

    @RequestMapping(value="/course/seminar/info")
    public String seminarInfo(HttpServletRequest request,BigInteger classId,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSeminarControlByClassIdAndSeminarInfoId(classId, seminarId);
        model.addAttribute("seminarControl",seminarControl);
        List<Presentation> presentationList= seminarControl.getPresentationList();
        List<Team> teamList=new ArrayList<>();
        for(int i=0;i<presentationList.size();i++)
        {
            teamList.add(presentationList.get(i).getTeam());
        }
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,seminarControl.getCourseClass().getCourse().getId());
        boolean flag=teamList.contains(team);
        model.addAttribute("enrollment",flag);
        return "student/course/seminar/info";
    }

    @RequestMapping(value="/course/seminar/score")
    public String seminarScore(HttpServletRequest request,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,seminarControl.getCourseClass().getCourse().getId());
        model.addAttribute("team",team);
        return "student/course/seminar/score";
    }

    @RequestMapping(value="/course/seminar/enrollment")
    public String enrollmentInfo(HttpServletRequest request,BigInteger seminarId, Model model) {
        SeminarControl seminarControl = seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        List<Presentation> presentationList= seminarControl.getPresentationList();
        List<Team> teamList=new ArrayList<>();
        for(int i=0;i<presentationList.size();i++)
        {
            teamList.add(presentationList.get(i).getTeam());
        }
        HttpSession session = request.getSession();
        BigInteger studentId=(BigInteger)session.getAttribute("id");
        Team team=teamService.getTeamByStudentIdAndCourseId(studentId,seminarControl.getCourseClass().getCourse().getId());
        boolean flag=teamList.contains(team);
        model.addAttribute("enrollment",flag);
        return "student/course/seminar/enrollment";
    }

    @RequestMapping(value="/course/seminar/run")
    public String seminarRun(Model model) {
        return "student/course/seminar/run";
    }

    @RequestMapping(value="/course/info")
    public String courseInfo(BigInteger courseId,Model model) {
        Course course=courseService.getCourseByCourseId(courseId);
        model.addAttribute("course",course);
        return "student/course/info";
    }

    @RequestMapping(value = "/activate",method = GET)
    public String activate(Model model) { return "student/activate"; }
}
