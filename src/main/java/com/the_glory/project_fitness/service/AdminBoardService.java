package com.the_glory.project_fitness.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_glory.project_fitness.dao.SharedDao;
import com.the_glory.project_fitness.utils.Paginations;

@Service

public class AdminBoardService {
    @Autowired
    SharedDao sharedDao;

    // 전체 검색
    public Object selectAll(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = " AdminBoard.selectAll";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        // result.put("resultList", this.selectSearch(dataMap));
        HashMap result1 = new HashMap<>();
        result1.putAll(this.selectSearchWithPagination(dataMap));
        return result1;
    }

    // 검색(조건-search : YEAR, CAR_NAME)
    public Map selectSearchWithPagination(Map dataMap) {
        // 페이지 형성 위한 계산
        int totalCount = (int) this.selectTotal(dataMap);

        int currentPage = 1;
        if (dataMap.get("currentPage") != null) {
            currentPage = Integer.parseInt((String) dataMap.get("currentPage")); // from client in param
        }

        Paginations paginations = new Paginations(totalCount, currentPage);
        HashMap result = new HashMap<>();
        result.put("paginations", paginations); // 페이지에 대한 정보

        // page record 수
        String sqlMapId = "AdminBoard.selectSearchWithPagination";
        dataMap.put("pageScale", paginations.getPageScale());
        dataMap.put("pageBegin", paginations.getPageBegin());

        result.put("resultList", sharedDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }

    public Object selectTotal(Map dataMap) {
        String sqlMapId = "AdminBoard.selectTotal";

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }
}