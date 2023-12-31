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
    private SharedDao sharedDao;
    AdminBoardAnswerService adminBoardAnswerService;

    // 전체 검색
    public Object selectAll(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "AdminBoard.selectAll";
        HashMap result = new HashMap<>();
        result.putAll(this.selectSearchWithPagination(dataMap));
        // result.put("resultList", sharedDao.getList(sqlMapId, dataMap));
        // result.put("resultList", this.selectSearch(dataMap));
        // HashMap result1 = new HashMap<>();
        // result1.putAll(this.selectSearchWithPagination(dataMap));
        return result;
    }

    public Object selectboard(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "AdminBoard.selectboard";
        HashMap result = new HashMap<>();
        result.putAll(this.selectSearchWithPagination2(dataMap));
        // result.put("resultList", sharedDao.getList(sqlMapId, dataMap));
        // result.put("resultList", this.selectSearch(dataMap));
        // HashMap result1 = new HashMap<>();
        // result1.putAll(this.selectSearchWithPagination(dataMap));
        return result;
    }

    // (페이지네이션)
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

    // selectTotal 총수
    public Object selectTotal(Map dataMap) {
        String sqlMapId = "AdminBoard.selectTotal";

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    // 게시판용 pagination
    public Map selectSearchWithPagination2(Map dataMap) {
        // 페이지 형성 위한 계산
        int totalCount = (int) this.selectTotal2(dataMap);

        int currentPage = 1;
        if (dataMap.get("currentPage") != null) {
            currentPage = Integer.parseInt((String) dataMap.get("currentPage")); // from client in param
        }

        Paginations paginations = new Paginations(totalCount, currentPage);
        HashMap result = new HashMap<>();
        result.put("paginations", paginations); // 페이지에 대한 정보

        // page record 수
        String sqlMapId = "AdminBoard.selectSearchWithPagination2";
        dataMap.put("pageScale", paginations.getPageScale());
        dataMap.put("pageBegin", paginations.getPageBegin());

        result.put("resultList", sharedDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }

    public Object selectTotal2(Map dataMap) {
        String sqlMapId = "AdminBoard.selectTotal2";

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    // selectSearch 수
    public Object selectSearch(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "AdminBoard.selectSearch";

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // 검색()
    public Object selectSearch(String search, String words) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "AdminBoard.selectSearch";
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // public Object selectDetail(Map paramMap) {
    // // Object getOne(String sqlMapId, Object dataMap)
    // String sqlMapId = "AdminBoard.selectSearch"; // xml의 namespace와 각각 ID의 조합해서
    // 유니크 아이디를 만듬
    // HashMap dataMap = new HashMap<>();
    // dataMap.put("BOARD_ID", paramMap);

    // Object result = sharedDao.getOne(sqlMapId, dataMap);
    // return result;
    // }

    // 회원세부정보
    public Object selectDetail(Map paramMap) {
        String sqlMapId = "AdminBoard.selectSearch"; // xml의 namespace와 각각 ID의 조합해서 유니크 아이디를 만듬

        Object result = sharedDao.getOne(sqlMapId, paramMap);
        return result;
    }

    // 회원 정보 삭제
    public Object deleteAndSelectSearch(Map dataMap) {

        // String sqlMapId = "CarInfors.delete";
        // result.put("deleteCount", sharedDao.delete(sqlMapId, dataMap));
        this.delete(dataMap);
        Object result = (Object) this.selectAll(dataMap);

        // sqlMapId = "CarInfors.selectSearch";
        // result.put("resultList", sharedDao.getOne(sqlMapId, dataMap));
        return result;
    }

    // 회원 정보 삭제2(FK 삭제 후 PK 삭제) 후 출력
    // MVC view- delete1
    public Object delete(Map params) {
        String sqlMapId = "AdminBoardAnswer.delete";
        String sqlMapId_1 = "AdminBoard.delete";
        Object result = sharedDao.delete(sqlMapId, params);
        Object result_1 = sharedDao.delete(sqlMapId_1, params);

        return result;
    }

    // 2PC delete
    public Object deleteDouble(Map dataMap) {
        String sqlMapId = "AdminBoard.delete";
        // sucess
        Object result = sharedDao.delete(sqlMapId, dataMap);
        // error
        result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    // // MVC view -insertAndSelectSearch(등록)
    // public Object insertAndSelectSearch(Map dataMap) {
    // // UniqueID uniqueid = new UniqueID();
    // // String uuid = uniqueid.generatUuid();
    // // HashMap result = new HashMap<>();
    // // result.put("insertCount", this.insert(dataMap));

    // result.putAll(this.selectSearchWithPagination(dataMap));
    // return result;
    // }

    // MVC view -insert(등록)
    public Object insert(Map dataMap) {
        String sqlMapId = "AdminBoard.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    // MVC view -AdminBoardupdate(업데이트)

    public Object AdminBoardupdate(String ID, Map dataMap) {
        String sqlMapId = "AdminBoard.AdminBoardupdate";
        Object result = sharedDao.update(sqlMapId, dataMap);

        return result;
    }

    // ★2023-07-28 추가
    // MVC view -selectSearchTotal(업데이트)
    public int selectSearchTotal(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap);
        String sqlMapId = "AdminBoard.selectSearchTotal";
        // Object result = sharedDao.getList(sqlMapId, dataMap);
        // result.put("resultList", this.selectSearch(dataMap));
        return (int) sharedDao.getOne(sqlMapId, dataMap);
    }

    public Object selectDetail(String BOARD_ID, Map dataMap) {
        String sqlMapId = "AdminBoard.selectDetail";
        dataMap.put("BOARD_ID", BOARD_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }
}