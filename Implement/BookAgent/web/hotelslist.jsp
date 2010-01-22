<%-- 
    Document   : hotelslist
    Created on : Jan 22, 2010, 10:48:18 AM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Hotel.ListHotel, Hotel.Hotel" %>

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
                <table border="0" cellspacing="5">
                    <tbody>
                        <%
            ListHotel hotels = (ListHotel) request.getAttribute("hotels");
            for (int i = 0; i < hotels.getHotels().size(); i++) {
                Hotel hotel = hotels.getHotels().get(i);
                        %>
                        <tr>
                            <td><span><%= hotel.getName()%></span></td>
                        </tr>
                        <tr>
                            <td>
                                <table border="0" cellspacing="2">
                                    <tbody>
                                        <tr>
                                            <td width="50px" height="50px"><img src="img/hotel.jpg" alt="Khách sạn" /></td>
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
                        <%
            }
                        %>
                    </tbody>
                </table>


            </div>
            <jsp:include page="template/footer.jsp" />
        </div>
    </body>
</html>
