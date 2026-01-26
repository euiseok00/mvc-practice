package com.demo.devfun.controller;

import com.demo.devfun.dao.HomeDao;
import com.demo.devfun.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


//단순 자바 클래스가 아닌 Spring MVC 컨트롤러 선언
@Controller
public class HomeController {

    // 실제 비지니스 로직을 처리할 HomeService를 주입받아 처리
    @Autowired
    HomeService homeService;

    // 브라우저 주소창에 도메인/requests라고 입력하면 이 메서드가 실행됨
    @RequestMapping(value="/requests", produces = "application/json")
    // 데이터(Map)그대로 브라우저에 전달
    @ResponseBody
    public Map<String, Object> getRequestInfo(){

        return homeService.getRequestInfo();
    }
}

/*
데이터 흐름
1. 사용자: http://localhost:8080/requests 호출
2. HomeController: "오! /requests 요청이 왔네? getRequestInfo() 실행하자."
3. HomeService: 컨트롤러가 호출한 homeService.getRequestInfo()가 실행됨 (여기서 로직 처리)
4. 반환: Service가 넘겨준 Map 데이터를 @ResponseBody가 JSON 형태로 변환하여 사용자 브라우저에 뿌려줌.
 */
