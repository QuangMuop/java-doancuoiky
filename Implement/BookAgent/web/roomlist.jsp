
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
        int pageIndex = Integer.parseInt(request.getParameter("p"));

        if (hotel == null) {
                    %>
                    <p>Bạn phải chọn khách sạn để xem danh sách phòng.</p>
                    <%                } else {
                    %>
                    <table border="1" width="60%">
                        <thead>
                            <tr>
                                <th width="10%">Số hiệu phòng</th>
                                <th width="60%">Đơn giá</th>
                                <th>Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
            ListRoom listRoom = hotel.getListRoom();
            List<Room> roomPage = listRoom.getRooms(pageIndex);
            for (int i = 0; i < roomPage.size(); i++) {
                Room room = roomPage.get(i);
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
                            %>
                        </tbody>
                    </table>
                    <span class="page_navigate">
                        <%
            for (int i = 0; i < listRoom.getPageCount(); i++) {
                        %>
                        <a href="hotels?action=get-rooms&hid=<%= hotel.getId()%>&p=<%= i%>"><%= i%></a>&nbsp;
                        <%
            }
        }
                        %>
                    </span>
                </div>
            </div>
            <jsp:include page="template/footer.jsp" />
        </div>
    </body>
</html>
