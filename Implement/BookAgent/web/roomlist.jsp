<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>
<%@page import="Agent.HotelController, Hotel.RoomInfo, java.util.*" %>


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
                    <th>Số người tối đa</th>
                    <th>Tình trạng</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
        <%
        List<RoomInfo> rooms = (List<RoomInfo>) request.getAttribute("rooms");
        for (int i = 0; i < rooms.size(); i++) {
            RoomInfo room = rooms.get(i);
        %>
                <tr>
                    <td><%= room.getId() %></td>
                    <td><%= (room.getMaxPeople() == 0)? 4 : room.getMaxPeople() %></td>
                    <td><%= (room.isCanStay())? "Trống" : "Không trống" %></td>
                    <td>url</td>
                </tr>
        <% } %>
            </tbody>
        </table>
        <jsp:include page="template/footer.jsp" />
    </body>
</html>
