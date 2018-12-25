package com.test.seminar.controller;

import com.test.seminar.dao.TeamDao;
import com.test.seminar.entity.Message;
import com.test.seminar.entity.Question;
import com.test.seminar.entity.SeminarRoom;
import com.test.seminar.service.RundSeminarService;
import com.test.seminar.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RunSeminarController {

    @Autowired
    private RundSeminarService rundSeminarService;
    @Autowired
    private TeamService teamService;
    @Autowired
    public SimpMessagingTemplate template;
    private Map<BigInteger, SeminarRoom> seminarRoomMap=new HashMap<>();

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
