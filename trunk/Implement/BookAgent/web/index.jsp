<%-- 
    Document   : index
    Created on : Dec 19, 2009, 8:39:14 PM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="hotelModel" scope="application" class="Agent.HotelModel" />


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Agency</title>
    </head>
    <body>
        <jsp:include page="template/header.jsp" />
        <p>
            Chương trình: Đặt vé qua mạng cho khách sạn. <br />
            Ngôn ngữ: Jsp, Xml<br />
            Thực hiện:<br />
            - Nguyễn Hoàng Vũ<br />
            - Nguyễn Xuân Tường Huy<br />
        </p>
        <jsp:include page="template/footer.jsp" />
    </body>
</html>
