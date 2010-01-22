<%-- 
    Document   : hotelslist
    Created on : Jan 22, 2010, 10:48:18 AM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Hotel.ListHotel, Hotel.Hotel, java.util.List" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách khách sạn</title>
        <link rel="stylesheet" type="text/css" href="img/stdtheme.css" />
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="template/header.jsp" />
            <div class="body">
                <div class="main-panel">
                    <table border="0" cellspacing="5">
                        <tbody>
                            <%
        ListHotel hotels = (ListHotel) request.getAttribute("hotels");
        int pageIndex = Integer.parseInt(request.getParameter("p"));

        if (hotels != null) {
            List<Hotel> hotelPage = hotels.getHotels(pageIndex);
            for (int i = 0; i < hotelPage.size(); i++) {
                Hotel hotel = hotelPage.get(i);
                            %>
                            <tr>
                                <td>
                                    <span class="hotel_title">
                                        <a class="hotel_title" href="hotels?action=get-hotel-info&hid=<%= hotel.getId()%>"><%= hotel.getName()%></a>
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table border="0" cellspacing="2">
                                        <tbody>
                                            <tr>
                                                <td><img src="img/hotel.jpg" alt="Khách sạn" height="150px" /></td>
                                                <td align="top">
                                                    <span class="hotel_detail">
                                                        Địa chỉ: <%= hotel.getAddress()%><br />
                                                        <%= hotel.getDetail()%>
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td align="left">
                                    <a href="hotels?action=get-rooms&hid=<%= hotel.getId()%>&p=0">Xem phòng</a>&nbsp;
                                    <a href="room?action=cancel-nav&hid=<%= hotel.getId()%>">Hủy đặt phòng</a>
                                </td>
                            </tr>
                            <%
                }
                            %>
                        </tbody>
                    </table>
                    <span class="page_navigate">
                        <%
                for (int i = 0; i < hotels.getPageCount(); i++) {
                        %>
                        <a href="hotels?action=get-hotels&p=<%= i%>" class="mainMenuItem"><%= i%></a>&nbsp;
                        <%
                }
                        %>
                    </span>
                    <%
        }
                    %>
                </div>
            </div>
            <jsp:include page="template/footer.jsp" />
        </div>
    </body>
</html>
