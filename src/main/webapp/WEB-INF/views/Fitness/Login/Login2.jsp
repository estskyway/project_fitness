<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="/CSS/Login2.css">

    </head>

    <body>

        <section class="login-form">
            <h1>
                <a href="/">
                    <img src="/Image/로고2.png" alt="로고" width="100" height="100">
                </a>

                <span class="brown">F</span>
                <span class="brown">I</span>
                <span class="brown">T</span>
                <span class="brown">-</span>
                <span class="green"> </span>
                <span class="green">G</span>
                <span class="red">Y</span>
                <span class="yellow">M</span>

            </h1>
            <form class="form-signin" method="post" action="/login">
                <div class="int-area">
                    <input type="text" name="username" id="id" class="form-label" >
                    <label for="id" class="sr-only">USER NAME</label>
                </div>
                <div class="int-area">
                    <input type="password" name="password" id="pw" class="form-label" >
                    <label for="pw" class="sr-only">PASSWORD</label>
                </div>
                <div class="btn-area">
                    <button id="btn" type="submit">LOGIN</button>
                </div>
            </form>
            <hr> <!-- 구분선 -->
            <form action="/Join">
                <div class="btn-area">
                    <button id="signup-btn" type="submit">회원가입</button> <!-- 회원가입 버튼 -->
                </div>
                <div class="caption">
                    <a href="">Forgot Password</a>
                </div>
            </form>
            <form action="/">
                <div class="btn-area">
                    <button id="signup-btn" type="submit">홈</button>
                </div>    
            </form>
        </section>

        <script>
        $(document).ready(function () {
            let id = $('#id');
            let pw = $('#pw');
            let btn = $('#btn');

            $(btn).on('click', function (e) {
                e.preventDefault(); // Prevent form submission for demonstration purposes

                if ($(id).val() === "") {
                    $(id).next('label').addClass('warning');
                    setTimeout(function () {
                        $(id).next('label').removeClass('warning');
                    }, 1500);
                }
                else if ($(pw).val() === "") {
                    $(pw).next('label').addClass('warning');
                    setTimeout(function () {
                        $(pw).next('label').removeClass('warning');
                    }, 1500);
                }
            });
        });
    </script>
    </body>

    </html>