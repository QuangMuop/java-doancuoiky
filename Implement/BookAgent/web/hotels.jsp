<%-- 
    Document   : hotels
    Created on : Dec 19, 2009, 8:41:57 PM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>
<%@page import="Hotel.Hotel, Agent.*, Agent.*, java.util.*" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Khách sạn</title>
        <link rel="stylesheet" type="text/css" href="img/stdtheme.css" />
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="template/header.jsp" />
            <div class="body">
                <jsp:include page="template/left-panel.jsp" />
                <div class="main-panel">
                    <%
        Hotel hotel = (Hotel) request.getAttribute("hotel");
        if (hotel != null) {
                    %>
                    <table border="0" width="800px">
                        <tbody>
                            <tr>
                                <td width="70px"><b>Tên:</b></td>
                                <td><%= hotel.getName()%></td>
                            </tr>
                            <tr>
                                <td><b>Địa chỉ:</b></td>
                                <td><%= hotel.getAddress()%></td>
                            </tr>
                            <tr>
                                <td><b>Giới thiệu:</b></td>
                                <td><%= hotel.getDetail()%></td>
                            </tr>
                        </tbody>
                    </table>
                    <br />
                    <a href="hotels?action=get-rooms&hid=<%= hotel.getId()%>&p=0">Xem phòng</a>&nbsp;
                    <a href="room?action=cancel-nav&hid=<%= hotel.getId()%>">Hủy đặt phòng</a>
                    <%
        }
                    %>
                </div>
            </div>
            <jsp:include page="template/footer.jsp" />
        </div>
    </body>
</html>
