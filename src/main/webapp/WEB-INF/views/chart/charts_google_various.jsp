<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap, java.util.ArrayList, com.the_glory.project_fitness.utils.Paginations" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Google Charts API -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
    <title>차트 관리</title>
    <link rel="stylesheet" href="/CSS/mainmenu.css">
</head>


<body>
    <%@ include file="/WEB-INF/views/Fitness/header.jsp" %>

        <div class="container-fluid">
            <!-- 관리자 페이지 content -->
            <div class="row g-20 vh-50">
               <!-- 관리자 전용 메뉴 -->
               <%@ include file="\WEB-INF\views\Fitness\Admin\Admin_menu.jsp"%>
                <div class="container mt-4 col-9">
                    <div class="">
                        <button type="button" class="text-start" style="width: auto;" onclick="golist();">가입자현황확인</button>
                        <!-- Bar Chart -->
                        
                        <div  style="height:fit-content" id="barChart" ></div>
                    </div>

                    <div class="">
                        <button type="button" class="text-start" style="width: auto;" onclick="showlinechart();">월별 가입자 현황</button>
                        <div class="" id="lineChart"></div>
                    </div>

                    <div class="">
                        <!-- Pie Chart and Line Chart -->
                        <button type="button" class="text-start" style="width: auto;" onclick="showpiechart();">지역 체육시설 비율</button>
                        <div class="" id="pieChart"></div>
                        
                    </div>
                    
                </div>
            </div>
        </div>
        <!-- JavaScript Code -->
        <script type='text/javascript'>
        
            // Load the Visualization API and the corechart package
            google.charts.load('current', { 'packages': ['corechart'] });

            // Set a callback to run when the Google Visualization API is loaded
            google.charts.setOnLoadCallback(drawCharts);
            // var jsonString = '[{"name": "John", "age": 30}, {"name": "Jane", "age": 25}]';
            // var jsonArray = JSON.parse(jsonString); json을 array 형식 변환. 

            // Coordinates and Location Names
            let locations = [
                { lat: 37.5666791, lng: 126.9782914, name: '서울' },
                { lat: 37.566535, lng: 126.9779692, name: '광화문' },
                { lat: 37.5586867, lng: 126.9782364, name: '명동' },
                { lat: 37.5551483, lng: 126.9707136, name: '남대문 시장' },
                { lat: 37.5617981, lng: 127.0071515, name: '강남역' },
                { lat: 37.5701391, lng: 127.0079479, name: '삼성동' },
                { lat: 37.5296212, lng: 127.0325739, name: '잠실' }
            ];

            // Initialize and Display the Map
            function initMap() {
                let map = new google.maps.Map(document.querySelector('#map'), {
                    zoom: 12,
                    center: { lat: 37.5666791, lng: 126.9782914 } // Seoul Coordinates
                });

                // Add Markers and Info Windows
                for (let i = 0; i < locations.length; i++) {
                    let marker = new google.maps.Marker({
                        position: locations[i],
                        map: map,
                        title: locations[i].name
                    });

                    let infowindow = new google.maps.InfoWindow({
                        content: locations[i].name
                    });

                    marker.addListener('click', function () {
                        infowindow.open(map, this);
                    });
                }
            }
        </script>
        <%@ include file="/WEB-INF/views/Fitness/footer.jsp" %>
        <!-- <script src="./js/chart_fetch.js"></script> -->
            <!-- Bootstrap Bundle with Popper.js and Bootstrap JS -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
            <script src="/js/chart_fetch.js"></script>

</body>

</html>