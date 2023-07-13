<%@ page import="java.util.HashMap, java.util.ArrayList" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>운동 시설 찾아주는 홈페이지</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
      <link rel="stylesheet" href="/CSS/mainmenu.CSS">
    </head>

    <body>
      <!-- 상단 네비게이션 바 -->
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="#">
            <img src="/Image/gym2.png.png" alt="로고" height="100">
          </a>
          <!-- 검색창 -->
          <form class="d-flex col-lg-5">
            <input class="form-control search-input me-2" type="search" placeholder="검색" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">검색</button>
          </form>
          <div class="col-lg-4 text-lg-end">
            <ul class="navbar-nav ms-auto">
              <li class="nav-item">
                <a class="nav-link" href="./gym.html">홈</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">소개</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="./reserve.html">예약</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="communityDropdown" role="button" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false">커뮤니티</a>
                <div class="dropdown-menu" aria-labelledby="communityDropdown">
                  <a class="dropdown-item" href="#">공지사항</a>
                  <a class="dropdown-item" href="#">게시판</a>
                  <a class="dropdown-item" href="#">후기</a>
                </div>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="./Login.html">로그인</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="./Join.html">회원가입</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <!-- Carousel -->
      <div class="container">
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="/Image/IMG_2389.jpg" class="d-block w-100" alt="이미지1">
            </div>
            <div class="carousel-item">
              <img src="/Image/IMG_2405.jpg" class="d-block w-100" alt="이미지2">
            </div>
            <div class="carousel-item">
              <img src="/Image/SJ1_2779-1.jpg" class="d-block w-100" alt="이미지3">
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>

      <!-- Footer -->
      <footer class="footer mt-4 container">
        <div class="row">
          <div class="col-9">
            <div>
              <div class="footer-content">
                <div class="footer-section links" style="text-align: left;">
                  <a href="#">홈 | </a></li>
                  <a href="#"> 서비스 |</a></li>
                  <a href="#"> 제품 | </a></li>
                  <a href="#"> 블로그</a></li>
                </div>
              </div>
            </div>
            <div class="footer-center" style="text-align: left;">
              <p>더글로리Co.| 대표:백구 | 개인정보보호책임자 : 백구 | 사업자등록번호 : 23-202307121</P>
              <p>통신판매신고번호 : 2023-직업학교-0711 | 주소 : 서울시 구로구</p>
            </div>
            <div class="footer-bottom" style="text-align: left;">
              <p>저작권 © 더글로리Co. All rights reserved.</p>
            </div>
    
          </div>
          <div class="col-3" style="text-align: left;">
            <div id="callcenter">
              <P>고객센터 : 09 ~ 18시</P>
            </div>
            <div id="infors">
              <p>전화번호 : 032-1587-4824</p>
              <P>E-MAIL : theGlroy@glroy.com</P>
            </div>
          </div>
        </div>
      </footer>
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>

    </html>