package com.the_glory.project_fitness.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_glory.project_fitness.UniqueID.UniqueID;
import com.the_glory.project_fitness.dao.SharedDao;
import com.the_glory.project_fitness.utils.Paginations;

@Service
public class NoticeService {
    @Autowired
    SharedDao sharedDao;

    // 전체 검색
    public Object selectAll(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "Notice.selectSearch";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        // result.put("resultList", this.selectSearch(dataMap));
        
        HashMap result1 = new HashMap<>();
        result1.putAll(this.selectSearchWithPagination(dataMap));
        return result1;
    }

    public Object selectDetail(String NOTICE_ID, Map dataMap) {
        String sqlMapId = "Notice.selectDetail";
        dataMap.put("NOTICE_ID", NOTICE_ID);
        
        Object result = sharedDao.getOne(sqlMapId, dataMap);
        // result.put("resultList", this.selectSearch(dataMap));
        return result;
    }

    // 검색(조건-search : YEAR, CAR_NAME)
    public Map selectSearchWithPagination(Map dataMap) {
        // 페이지 형성 위한 계산
        int totalCount = (int) this.selectSearchTotal(dataMap);
        
        int currentPage =1;
        if (dataMap.get("currentPage") != null) {
            currentPage = Integer.parseInt((String) dataMap.get("currentPage")); // from client in param
        }

        Paginations paginations = new Paginations(totalCount, currentPage);
        HashMap result = new HashMap<>();
        result.put("paginations", paginations); // 페이지에 대한 정보
        
        // page record 수
        String sqlMapId = "Notice.selectSearchWithPagination";
        dataMap.put("pageScale", paginations.getPageScale());
        dataMap.put("pageBegin", paginations.getPageBegin());

        result.put("resultList", sharedDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }

    public Object selectTotal(Map dataMap) {
        String sqlMapId = "Notice.selectTotal";

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public int selectSearchTotal(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap);
        String sqlMapId = "Notice.selectSearchTotal";
        // Object result = sharedDao.getList(sqlMapId, dataMap);
        // result.put("resultList", this.selectSearch(dataMap));
        return (int) sharedDao.getOne(sqlMapId, dataMap);
    }

    public Object insertAndSelectSearch(Map dataMap) {
        // UniqueID uniqueid = new UniqueID();
        // String uuid = uniqueid.generatUuid();
        HashMap result = new HashMap<>();
        result.put("insertCount", this.insert(dataMap));

        result.putAll(this.selectSearchWithPagination(dataMap));
        return result;
    }

    public Object insert(Map dataMap) {
        String sqlMapId = "Notice.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object selectSearch(Map dataMap) {
       
        HashMap result1 = new HashMap<>();
        result1.putAll(this.selectSearchWithPagination(dataMap));
        return result1;
    }

    // // 검색(조건-search : YEAR, CAR_NAME)
    // public Object selectSearch(String search, String words) {
    //     // Object getOne(String sqlMapId, Object dataMap)
    //     String sqlMapId = "Notice.selectSearch";
    //     HashMap dataMap = new HashMap<>();
    //     dataMap.put("search", search);
    //     dataMap.put("words", words);

    //     Object result = sharedDao.getList(sqlMapId, dataMap);

    //     HashMap result1 = new HashMap<>();
    //     result1.putAll(this.selectSearchWithPagination(dataMap));
    //     return result;
    // }


    // 회원 정보 삭제
    public Object memdelete(Map dataMap) {
        String sqlMapId = "Notice.memdelete";
        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    public Object noticeUpdate(Map dataMap){
        String sql = "Notice.NoticeUpdate";
        Object result = sharedDao.update(sql, dataMap);
        return result;
    }


    
}
