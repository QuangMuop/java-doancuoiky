
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>
<%@page import="Agent.*, Hotel.*, java.util.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách phòng</title>
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
        if (hotel == null) {
                    %>
                    <p>Bạn phải chọn khách sạn để xem danh sách phòng.</p>
                    <%                } else {
                    %>
                    <table border="1" width="60%">
                        <thead>
                            <tr>
                                <th width="10%">ID</th>
                                <th width="60%">Gia</th>
                                <th>Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                ListRoom listRoom = hotel.getListRoom();
                for (int i = 0; i < listRoom.size(); i++) {
                    Room room = listRoom.getRooms().get(i);
                            %>
                            <tr>
                                <td><%= room.getId()%></td>
                                <td><%= room.getCost()%></td>
                                <td>
                                    <% if (room.getStay()) {%>
                                    <a href="room?action=book-nav&hid=<%= hotel.getId()%>&rid=<%= room.getId()%>">Đặt</a>
                                    <%
 } else {%>
                                    Hết chỗ
                                    <%                    }
                                    %>
                                </td>
                            </tr>
                            <%
            }
        }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <jsp:include page="template/footer.jsp" />
        </div>
    </body>
</html>
