package com.the_glory.project_fitness.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_glory.project_fitness.dao.SharedDao;
import com.the_glory.project_fitness.utils.Paginations;

@Service

public class AdminBoardAnswerService {
   
    @Autowired
    private SharedDao sharedDao;
     
    @Autowired
    AdminBoardService adminBoardService;

    // 전체 검색
    public Object selectAll(Map dataMap){
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "AdminBoardAnswer.selectAll";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        // result.put("resultList", this.selectSearch(dataMap));
        HashMap result1 = new HashMap<>();
        return result;
    }

    // // 검색(조건-search : YEAR, CAR_NAME)
    // public Map selectSearchWithPagination(Map dataMap) {
    //     // 페이지 형성 위한 계산
    //     int totalCount = (int) this.selectTotal(dataMap);

    //     int currentPage = 1;
    //     if (dataMap.get("currentPage") != null) {
    //         currentPage = Integer.parseInt((String) dataMap.get("currentPage")); // from client in param
    //     }

    //     Paginations paginations = new Paginations(totalCount, currentPage);
    //     HashMap result = new HashMap<>();
    //     result.put("paginations", paginations); // 페이지에 대한 정보

    //     // page record 수
    //     String sqlMapId = "AdminBoardAnswer.selectSearchWithPagination";
    //     dataMap.put("pageScale", paginations.getPageScale());
    //     dataMap.put("pageBegin", paginations.getPageBegin());

    //     result.put("resultList", sharedDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
    //     return result;
    // }

    
    // // selectTotal 수
    // public Object selectTotal(Map dataMap) {
    //     String sqlMapId = "AdminBoardAnswer.selectTotal";

    //     Object result = sharedDao.getOne(sqlMapId, dataMap);
    //     return result;
    // }

    // // selectSearch 수

    //  public Object selectSearch(Map dataMap) {
    //     String sqlMapId = "AdminBoard.selectSearch";

    //     Object result = sharedDao.getOne(sqlMapId, dataMap);
    //     return result;
    // }

        // 검색(조건-search : COMPANY, CAR_NAME)
    // 검색(조건-search : YEAR, CAR_NAME)
    
    
    // public Object selectSearch(Map dataMap) {
    //     // Object getOne(String sqlMapId, Object dataMap)
    //     String sqlMapId = "AdminBoardAnswer.selectSearch";

    //     Object result = sharedDao.getList(sqlMapId, dataMap);
    //     return result;
    // }

    // // 검색(조건-search : YEAR, CAR_NAME)
    // public Object selectSearch(String search, String words) {
    //     // Object getOne(String sqlMapId, Object dataMap)
    //     String sqlMapId = "AdminBoardAnswer.selectSearch";
    //     HashMap dataMap = new HashMap<>();
    //     dataMap.put("search", search);
    //     dataMap.put("words", words);

    //     Object result = sharedDao.getList(sqlMapId, dataMap);
    //     return result;
    // }



     public Object insertAndSelectSearch(Map params) {
        HashMap result = new HashMap<>();
        // String sqlMapId = "CarInfors.delete";
        // result.put("deleteCount", sharedDao.delete(sqlMapId, dataMap));
        result.put("insert", this.insert(params));

        // sqlMapId = "CarInfors.selectSearch";
        // result.put("resultList", sharedDao.getOne(sqlMapId, dataMap));
        
        return result;
    }

 // MVC view
    public Object insert(Map params){
        String sqlMapId = "AdminBoardAnswer.insert";
        sharedDao.insert(sqlMapId, params);
        Object result = adminBoardService.selectAll(params);
        return result;
    }

        public Object insertAnswer(Map params){
        String sqlMapId = "AdminBoardAnswer.insertAnswer";
        Object result = sharedDao.insert(sqlMapId, params);
        return result;
    }




    // MVC view
    public Object delete(Map params){
        String sqlMapId = "AdminBoardAnswer.delete";
        Object result = sharedDao.delete(sqlMapId, params);
        return result;
    }

    // // MVC view -delete2 
    // public Object deleteAndSelectSearch(Map params) {
    //     HashMap result = new HashMap<>();
    //     // String sqlMapId = "CarInfors.delete";
    //     // result.put("deleteCount", sharedDao.delete(sqlMapId, dataMap));
    //     result.put("deleteCount", this.delete(params));

    //     // sqlMapId = "CarInfors.selectSearch";
    //     // result.put("resultList", sharedDao.getOne(sqlMapId, dataMap));
        
    //     result.putAll(this.selectSearchWithPagination(params));
    //     return result;
    // }



    // // 2PC delete
    // public Object deleteDouble(Map dataMap) {
    //     String sqlMapId = "AdminBoardAnswer.delete";
    //     // sucess
    //     Object result = sharedDao.insert(sqlMapId, dataMap);
    //     // error
    //     result = sharedDao.insert(sqlMapId, dataMap);
    //     return result;
    // }


}