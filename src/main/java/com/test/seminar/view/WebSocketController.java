package com.test.seminar.view;

import com.test.seminar.entity.Student;
import com.test.seminar.entity.Team;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


@Controller
public class WebSocketController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Team makeQuestion(Student student) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Team();

    }
}
