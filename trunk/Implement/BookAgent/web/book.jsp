<%-- 
    Document   : book
    Created on : Dec 19, 2009, 8:42:12 PM
    Author     : hvu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="template/header.jsp" />
        <h2>Ten khach san</h2>
        <form action="book">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Mã số phòng</td>
                        <td>
                            <select name="listRooms">
                                <option selected="true">Phòng 1</option>
                                <option>Phòng 2</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Số người</td>
                        <td><input type="text" name="peopleCount" value="1" /></td>
                    </tr>
                    <tr>
                        <td><br />Thông tin người đại diện</td>
                    </tr>
                    <tr>
                        <td>Tên</td>
                        <td><input type="text" name="name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Ngày sinh</td>
                        <td><input type="text" name="birth" value="" /></td>
                    </tr>
                    <tr>
                        <td>CMND</td>
                        <td><input type="text" name="personalId" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Đăng ký" name="btnBook" /> &nbsp;
            <input type="reset" value="Xóa" name="btnClear" /> &nbsp;
            <input type="button" value="Trở lại" name="btnBack" /> &nbsp;
        </form>
        <jsp:include page="template/footer.jsp" />
    </body>
</html>
