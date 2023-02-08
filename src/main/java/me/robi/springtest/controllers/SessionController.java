package me.robi.springtest.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @GetMapping("/start")
    public ResponseEntity startSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int randomValue = ThreadLocalRandom.current().nextInt(100);
        session.setAttribute("test", randomValue);
        return new ResponseEntity<>(Collections.singletonMap("value", randomValue), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put("id", session.getId());
        map.put("value", session.getAttribute("test"));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
