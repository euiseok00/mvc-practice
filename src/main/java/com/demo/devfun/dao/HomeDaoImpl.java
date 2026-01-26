package com.demo.devfun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// db에 접근하는 저장소 역할임을 선언
@Repository
public class HomeDaoImpl implements HomeDao{


    // MyBatis가 제공하는 도구, 자바 코드와 실제 sql 쿼리문을 연결
    @Autowired
    SqlSessionTemplate template;

    public HomeDaoImpl(SqlSessionTemplate template){
        super();
        this.template = template;
    }


    // com.test.springTest.testxml : XML 파일의 이름표, selectTest : 그 파일 안에 있는 특정 쿼리 id
    @Override
    public int getTestCount() {

        return template.selectOne("com.test.springTest.testxml.selectTest");
    }

    @Override
    public List<Map<String, Object>> getRequests() {


        return template.selectList("com.test.springTest.testxml.selectTest2");
    }
}
