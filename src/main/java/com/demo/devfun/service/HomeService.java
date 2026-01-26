package com.demo.devfun.service;

import com.demo.devfun.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 이 클래스가 비지니스 로직을 담당하는 서비스 레이어임을 선언
@Service
public class HomeService {

    // 데이터베이스에 직접 가서 게이터를 가져올 수 있는 HomeDao 주입받음
    @Autowired
    HomeDao homeDao;

    public Map<String,Object> getRequestInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("count", homeDao.getTestCount());
        map.put("sample", homeDao.getRequests());
        return map;
    }
}
