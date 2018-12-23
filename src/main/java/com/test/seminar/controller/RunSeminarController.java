package com.test.seminar.controller;

import com.test.seminar.service.RundSeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.Map;

@Controller
public class RunSeminarController {

    @Autowired
    private RundSeminarService rundSeminarService;
    private Map<BigInteger, Integer> seminarRoom;

    @MessageMapping("/QA")
    @SendTo("/topic/addQuestion")
    @ResponseBody
    public String greeting(BigInteger teamId, BigInteger seminarId, HttpSession session) throws Exception {
        rundSeminarService.addQuestion(seminarId,teamId,(BigInteger)session.getAttribute("id"));
        if(!seminarRoom.keySet().contains(seminarId)){
            seminarRoom.put(seminarId,0);
        }
        Integer count=seminarRoom.get(seminarId)+1;
        seminarRoom.put(seminarId,count);
        return "目前"+count.toString()+"人已提问";
    }
}
