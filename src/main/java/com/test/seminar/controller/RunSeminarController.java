package com.test.seminar.controller;

import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Message;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarControl;
import com.test.seminar.entity.SeminarRoom;
import com.test.seminar.service.RundSeminarService;
import com.test.seminar.service.SeminarService;
import com.test.seminar.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RunSeminarController {

    @Autowired
    private RundSeminarService rundSeminarService;
    @Autowired
    private TeamService teamService;
    @Autowired
    public SimpMessagingTemplate template;
    @Autowired
    public SeminarService seminarService;
    private Map<BigInteger, SeminarRoom> seminarRoomMap=new HashMap<>();

    @RequestMapping(value="/teacher/course/seminar/progressing")
    public String progressing(BigInteger seminarId, Model model) {
        rundSeminarService.beginSeminar(seminarId);
        SeminarControl seminarControl=seminarService.getSeminarControlBySeminarControlId(seminarId);
        model.addAttribute("seminarControl",seminarControl);
        return "teacher/course/seminar/progressing";
    }

    @RequestMapping(value = "/teacher/course/seminar/endSeminar",method = POST)
    @ResponseBody
    public ResponseEntity<String> endSeminar(BigInteger seminarId, String deadline, Model model) {
        SeminarControl mySeminar=seminarService.getSeminarControlBySeminarControlId(seminarId);
        System.out.println(deadline);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(deadline, pos);
        System.out.println(strtodate);
        mySeminar.setReportDDL(strtodate);
        rundSeminarService.endSeminar(mySeminar.getId());
        seminarService.updateSeminarControl(mySeminar);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @MessageMapping("/QA")
    @ResponseBody
    public void addQuestion(Message message) throws Exception {
        BigInteger seminarControlId=message.getSeminarId();
        rundSeminarService.addQuestion(seminarControlId,message.getTeamId(),message.getStudentId());
        SeminarRoom seminarRoom=seminarRoomMap.get(seminarControlId);
        seminarRoom.incCount();
        template.convertAndSendToUser(seminarControlId.toString(),"/addQuestion", "目前"+seminarRoom.getCount().toString()+"人已提问");
    }

    @MessageMapping("/nextGroup")
    @ResponseBody
    public void nextGroup(Message message){
        BigInteger seminarControlId=message.getSeminarId();
        rundSeminarService.nextPresentation(seminarControlId);
        SeminarRoom seminarRoom=seminarRoomMap.get(seminarControlId);
        seminarRoom.setCountZero();
        template.convertAndSendToUser(seminarControlId.toString(),"/nextGroup","OK");
        template.convertAndSendToUser(seminarControlId.toString(),"/addQuestion", "目前"+seminarRoom.getCount().toString()+"人已提问");
    }

    @MessageMapping("/buildRoom")
    @ResponseBody
    public void buildRoom(Message message) throws Exception {
        if(!seminarRoomMap.keySet().contains(message.getSeminarId())){
            seminarRoomMap.put(message.getSeminarId(),new SeminarRoom());
        }
    }

    @MessageMapping("/selectQuestion")
    @ResponseBody
    public void selectQuestion(Message message) throws Exception{
        SeminarRoom seminarRoom=seminarRoomMap.get(message.getSeminarId());
        if(seminarRoom.getCount()==0)
            return;
        Question question=rundSeminarService.selectQuestion(message.getSeminarId());
        template.convertAndSendToUser(message.getSeminarId().toString(),"/selectQuestion","当前"+question.getSerial().getSerial()+"正在提问");
        seminarRoom.decCount();
        template.convertAndSendToUser(message.getSeminarId().toString(),"/addQuestion", "目前"+seminarRoom.getCount().toString()+"人已提问");
    }

    @MessageMapping("/endSeminar")
    @ResponseBody
    public void endSeminar(Message message) throws Exception{
        template.convertAndSendToUser(message.getSeminarId().toString(),"/endSeminar","end");
    }
}
