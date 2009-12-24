<%-- 
    Document   : hotels
    Created on : Dec 19, 2009, 8:41:57 PM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>
<%@page import="Hotel.HotelInfo, Agent.HotelModel, Agent.StartUpServlet, java.util.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="template/header.jsp" />
        <%
            HotelInfo hotel = (HotelInfo) request.getAttribute("hotel");
        %>
        <div class="left">
            <%
            ArrayList<HotelInfo> hotels = StartUpServlet.listHotels;
            for (int i = 0; i < hotels.size(); i++ ) {
                HotelInfo h = hotels.get(i);
            %>
            <a href="hotels?hid=<%= h.getId() %>"><%= h.getName() %></a>
            <%
            }
            %>
        </div>

        <% if (hotel != null) { %>
        <div class="right">
            <table border="1" width="800px">
                <tbody>
                    <tr>
                        <td width="70px">Tên</td>
                        <td><%= hotel.getName() %></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ</td>
                        <td><%= hotel.getDescription() %></td>
                    </tr>
                    <tr>
                        <td>Mô tả</td>
                        <td><%= hotel.getAddress() %></td>
                    </tr>
                    <tr>
                        <td>Số phòng</td>
                        <td><%= hotel.getNumberOfRooms() %></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <% } %>

        <jsp:include page="template/footer.jsp" />
    </body>
</html>
