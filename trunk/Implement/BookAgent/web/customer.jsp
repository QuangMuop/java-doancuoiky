<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Hotel.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Khach hang</title>
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
                    <p>Bạn phải chọn khách sạn để có thể đăng ký đặt phòng được.</p>
                    <%                } else {
                    %>
                    <form action="room">
                        <table border="0">
                            <tbody>
                                <tr>
                                    <td>Ten:</td>
                                    <td><input type="text" name="name" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Ngay sinh (dd/mm/yyyy):</td>
                                    <td><input type="text" name="birth" value="" /></td>
                                </tr>
                                <tr>
                                    <td>CMND:</td>
                                    <td><input type="text" name="cmnd" value="" /></td>
                                </tr>
                            </tbody>
                        </table>

                        <input type="hidden" name="hid" value="<%= hotel.getId()%>" />
                        <input type="hidden" name="rid" value="<%= request.getParameter("rid")%>" />
                        <input type="hidden" name="action" value="book" />
                        <input type="submit" value="Chấp nhận" name="submit" />
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
