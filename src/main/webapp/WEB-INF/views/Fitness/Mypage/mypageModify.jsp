<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ page import="java.util.HashMap, java.util.ArrayList" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>운동 시설 찾아주는 홈페이지</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="/CSS/mypage.css">
      <link rel="stylesheet" href="/CSS/mainmenu.css">
    </head>

    <body>
      <!-- 상단 네비게이션 바 -->
      <%@ include file="/WEB-INF/views/Fitness/header.jsp" %>

        <% HashMap params=(HashMap) request.getAttribute("params"); String searchStr=(String)
          params.getOrDefault("search", "" ); HashMap result=(HashMap) request.getAttribute("result"); %>
          <!-- 마이페이지 -->
          <div class="container p-5">
            <h2 class="text-center fw-bold p-3">회원 정보 수정</h2>
            <div class="card-body">
              <form action="" class="m-4">
                <div class="mb-3">
                  <label for="name" class="form-label">이름</label>
                  <em class="required">*</em>
                  <input type="text" id="name" class="form-control" name="name" value='<%= result.get("NAME")%>'>
                </div>
                <div class="mb-3">
                  <label for="id" class="form-label">아이디</label>
                  <em class="required">*</em>
                  <input type="text" id="id" class="form-control" name="ID" value='<%= result.get("ID")%>' readonly>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">비밀번호</label>
                  <em class="required">*</em>
                  <input type="password" id="password" class="form-control" name="password"
                    value='<%= result.get("PASSWORD")%>'>
                </div>
                <div class="mb-3">
                  <label for="password" class="form-label">비밀번호 확인</label>
                  <em class="required">*</em>
                  <input type="password" id="passwordcheck" class="form-control" name="confirmpassword"
                    value='<%= result.get("PASSWORD")%>'>
                </div>
                <div class="mb-3">
                  <label for="gender">성별</label>
                  <br>
                  <div class="form-check form-check-inline row">
                    <div class="col-sm-10 mb-3">
                      <div class="form-check form-check-inline">
                        <%
                        String genderId = (String) result.get("GENDER_ID"); 
                        String maleChecked = "";
                        String femaleChecked = "";
                        if("GEN01".equals(genderId)) {
                          maleChecked = "checked";
                        } else if("GEN02".equals(genderId)) {
                          femaleChecked = "checked";        
                        }
                        %>
                        <input class="form-check-input" type="radio" name="GENDER_ID" value='GEN01' id="male" <%= maleChecked %>>
                        <label class="form-check-label" for="gender_male">남성</label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="GENDER_ID" value='GEN02' id="female" <%= femaleChecked %>>
                        <label class="form-check-label" for="gender_female">여성</label>
                      </div>
                    </div>
                  </div>
                  <div class="mb-3">
                    <label for="birthdate">생년월일:</label>
                    <input type="text" class="form-control" id="birthdate" name="birthdate" placeholder="YYYY-MM-DD"
                      readonly value='<%= result.get("BIRTHDATE")%>' oninput="formatDate(this)">
                  </div>
                  <div class="mb-3">
                    <label for="inputPhoneNumber" class="form-label">휴대폰번호</label>
                    <div class="input-group">
                      <input type="tel" class="form-control" id="inputPhoneNumber" name="phonenumber"
                        value='<%= result.get("PHONE_NUMBER") %>'>

                      <div class="input-group-append">
                        <span class="input-group-text">
                          <div class="input-group-text">
                            <input type="checkbox" aria-label="SMS Subscription">
                          </div>SMS 수신여부
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="mb-3">
                    <label for="inputEmail" class="form-label">이메일</label>
                    <em class="required">*</em>
                    <div class="input-group">
                      <input type="email" class="form-control" id="inputEmail" name="email"
                        value='<%= result.get("EMAIL_ADDRESS")%>' required>
                      <div class="input-group-append">
                        <span class="input-group-text">
                          <div class="input-group-text">
                            <input type="checkbox" aria-label="Email Subscription">
                          </div>메일 수신여부
                        </span>
                      </div>
                    </div>
                  </div>
                  <div class="mb-3">
                    <label for="inputZip" class="form-label">주소</label>
                    <div class="input-group">
                      <input type="text" class="form-control" id="inputAddress" name="address"
                        value='<%= result.get("ADDRESS")%>'>
                    </div>
                  </div>
                </div>
                <form action="">
                  <div class="card-footer d-flex justify-content-end">
                    <a href="/mypage" type="button" class="btn btn-secondary me-2">취소</a>
                    <button type="submit" class="btn btn-dark" data-toggle="modal" data-target="#completionModal"
                      onclick="showConfirmation()" formaction="/updateAndSelect">
                      완료
                    </button>
                </form>
            </div>

          </div>
          </div>
          </div>



          <!-- Footer -->
          <%@ include file="/WEB-INF/views/Fitness/footer.jsp" %>

            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

            <script src="/src/main/resources/static/js/mypageModify.js"></script>
    </body>

    </html>