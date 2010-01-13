<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>
<%@page import="Agent.*, Hotel.*, java.util.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách phòng</title>
    </head>
    <body>
        <jsp:include page="template/header.jsp" />
        <jsp:include page="template/left-panel.jsp" />
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Gia</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
        <%
        List<Room> rooms = (List<Room>) request.getAttribute("rooms");
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
        %>
                <tr>
                    <td><%= room.getId() %></td>
                    <td><%= room.getCost() %></td>
                    <td>url</td>
                </tr>
        <% } %>
            </tbody>
        </table>
        <jsp:include page="template/footer.jsp" />
    </body>
</html>
