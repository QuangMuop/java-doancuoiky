<%-- 
    Document   : hotels
    Created on : Dec 19, 2009, 8:41:57 PM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>
<%@page import="Hotel.*, Agent.*, Agent.*, java.util.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="template/header.jsp" />
        <jsp:include page="template/left-panel.jsp" />
        <%
            Hotel hotel = (Hotel) request.getAttribute("hotel");
            if (hotel != null) { %>
        <div class="main-panel">
            &nbsp;

            <table border="1" width="800px">
                <tbody>
                    <tr>
                        <td width="70px">Tên</td>
                        <td><%= hotel.getName() %></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ</td>
                        <td><%= hotel.getAddress() %></td>
                    </tr>
                    <tr>
                        <td>Mô tả</td>
                        <td><%= hotel.getDetail() %></td>
                    </tr>
                    <tr>
                        <td>Số phòng</td>
                        <td><%= hotel.getRoom() %></td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <br />
        <a href="hotels?action=get-rooms&hid=<%= hotel.getId() %>&all=0">Xem phòng trống</a>|
        <a href="hotels?action=get-rooms&hid=<%= hotel.getId() %>&all=1">Xem phòng</a>|
        <a href="book?action=book-nav&hid=<%= hotel.getId() %>">Đặt phòng</a>|
        <a href="book?action=unbook-nav&hid=<%= hotel.getId() %>">Hủy đặt phòng</a>
        <% } %>
        <jsp:include page="template/footer.jsp" />
    </body>
</html>
