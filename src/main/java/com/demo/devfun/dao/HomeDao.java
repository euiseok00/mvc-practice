package com.demo.devfun.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface HomeDao {

    // 필요한 데이터 형식 선언
    // 개수를 가져와야해, 리스트를 가져와야해
    int getTestCount();
    List<Map<String, Object>> getRequests();
}
