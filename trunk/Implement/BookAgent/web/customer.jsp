<%-- 
    Document   : customer
    Created on : Jan 14, 2010, 8:51:28 AM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Khach hang</title>
    </head>
    <body>
        <jsp:include page="template/header.jsp" />
        <jsp:include page="template/left-panel.jsp" />
        <form action="room">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Ten:</td>
                        <td><input type="text" name="name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Tuoi:</td>
                        <td><input type="text" name="age" value="" /></td>
                    </tr>
                    <tr>
                        <td>Dia chi:</td>
                        <td><input type="text" name="address" value="" /></td>
                    </tr>
                </tbody>
            </table>

            <input type="hidden" name="hid" value="<%= request.getParameter("hid") %>" />
            <input type="hidden" name="rid" value="<%= request.getParameter("rid") %>" />
            <input type="hidden" name="action" value="book" />
            <input type="submit" value="Submit" name="submit" />
        </form>
        <jsp:include page="template/footer.jsp" />
    </body>
</html>
