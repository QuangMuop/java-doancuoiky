<%-- 
    Document   : unbook
    Created on : Dec 30, 2009, 2:34:07 PM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>
<%@page import="Hotel.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trả phòng</title>
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
                if (hotel == null) {%>
                    <p>Bạn cần chọn một khách sạn mới có thể hủy đặt chỗ.</p>
                <%}
                else {
                %>
                <form name="form" action="room">
                    <input type="hidden" name="action" value="cancel" />
                    <input type="hidden" name="hid" value="<%= hotel.getId() %>" />
                    <label for="validation">Mã xác nhận: </label> <br />
                    <input type="text" name="validation" value="" size="50px" /> <br />
                    <input type="submit" value="Chấp nhận" />
                </form>
                <%
                }
                %>
            </div>
            </div>
            <jsp:include page="template/footer.jsp" />
        </div>
    </body>
</html>
