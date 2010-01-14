<%-- 
    Document   : unbook
    Created on : Dec 30, 2009, 2:34:07 PM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page session="true" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trả phòng</title>
    </head>
    <body>
        <jsp:include page="template/header.jsp" />
        <jsp:include page="template/left-panel.jsp" />
        <form name="form" action="room">
            <input type="hidden" name="action" value="unbook" />
            <input type="hidden" name="hid" value="<%= request.getParameter("hid") %>" />
            <label for="tbValidationCode">Mã xác nhận: </label>
            <input type="text" name="tbValidationCode" value="" size="200px" />
            <input type="submit" value="OK" name="btnUnbook" />
        </form>
        <jsp:include page="template/footer.jsp" />
    </body>
</html>
