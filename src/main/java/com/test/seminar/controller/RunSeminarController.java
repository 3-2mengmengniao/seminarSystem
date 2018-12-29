package com.test.seminar.controller;

import com.test.seminar.entity.*;
import com.test.seminar.service.RunSeminarService;
import com.test.seminar.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
/**
 * @author xmr
 * @date 2018/11/28
 */
@Controller
public class RunSeminarController {

    @Autowired
    private RunSeminarService runSeminarService;
    @Autowired
    public SimpMessagingTemplate template;
    @Autowired
    public SeminarService seminarService;

    /**
     * 进入讨论课
     * @param seminarId
     * @param status 0表示第一次进入，即开始，将在服务器端初始化数据。1表示普通的进入
     * @param model
     * @return
     */
    @RequestMapping(value="/teacher/course/seminar/progressing")
    public String progressing(BigInteger seminarId, int status,Model model) {
        SeminarControl seminarControl;
        if(status==0){
            seminarControl= runSeminarService.beginSeminar(seminarId);
        }
        else{
            seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        }
            model.addAttribute("seminarControl",seminarControl);
        return "teacher/course/seminar/progressing";
    }

    /**
     * 结束讨论课
     * @param seminarId 要结束的讨论课ID（班级下）
     * @param deadline 报告截止日期
     * @param model
     * @return
     */
    @RequestMapping(value = "/teacher/course/seminar/endSeminar",method = POST)
    @ResponseBody
    public ResponseEntity<String> endSeminar(BigInteger seminarId, String deadline, Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(deadline, pos);
        runSeminarService.endSeminar(seminarId,strtodate);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /**
     *前端提问
     * @param message 内部有seminarId,teamId,studentId
     * @throws Exception
     */
    @MessageMapping("/QA")
    @ResponseBody
    public void addQuestion(Message message) throws Exception {
        if(runSeminarService.getTeamIdInQuestion(message.getSeminarId()).contains(message.getTeamId())){
            return;
        }
        BigInteger seminarControlId=message.getSeminarId();
        runSeminarService.addQuestion(seminarControlId,message.getTeamId(),message.getStudentId());
        Integer count= runSeminarService.getQuestionNumberWaitToSelect(seminarControlId);
        template.convertAndSendToUser(seminarControlId.toString(),"/addQuestion", count.toString()+"人已提问");
    }

    /**
     * 下组展示
     * @param message 需要用到seminarId属性
     */
    @MessageMapping("/nextGroup")
    @ResponseBody
    public void nextGroup(Message message){
        BigInteger seminarControlId=message.getSeminarId();
        runSeminarService.nextPresentation(seminarControlId);
        Integer count= runSeminarService.getQuestionNumberWaitToSelect(seminarControlId);
        Presentation currentPresentation= runSeminarService.getCurrentPresentation(seminarControlId);
        template.convertAndSendToUser(seminarControlId.toString(),"/nextGroup",currentPresentation.getTeam().getSerial().getSerial()+"正在展示");
        template.convertAndSendToUser(seminarControlId.toString(),"/addQuestion", count.toString()+"人已提问");
    }

    /**
     * 抽取问题，如果后台无问题，无效
     * @param message 需要用到seminarId
     * @throws Exception
     */
    @MessageMapping("/selectQuestion")
    @ResponseBody
    public void selectQuestion(Message message) throws Exception{
        if(runSeminarService.getQuestionNumberWaitToSelect(message.getSeminarId())==0) {
            return;
        }
        runSeminarService.selectQuestion(message.getSeminarId());
        sendQuestionMessage(message.getSeminarId());
    }

    @MessageMapping("/endSeminar")
    @ResponseBody
    public void endSeminar(Message message) throws Exception{
        template.convertAndSendToUser(message.getSeminarId().toString(),"/endSeminar","end");
    }

    @MessageMapping("/welcome")
    public void welcome(Message message){
        sendQuestionMessage(message.getSeminarId());
        //template.convertAndSendToUser(message.getSeminarId().toString(),);
    }

    private void sendQuestionMessage(BigInteger seminarControlId){
        Integer count= runSeminarService.getQuestionNumberWaitToSelect(seminarControlId);
        Question selectQuestion= runSeminarService.getSelectQuestion(seminarControlId);
        if(null!=selectQuestion){
            template.convertAndSendToUser(seminarControlId.toString(),"/selectQuestion",new QuestionDTO(selectQuestion));
        }
        template.convertAndSendToUser(seminarControlId.toString(),"/addQuestion", count.toString()+"人已提问");
    }
}
