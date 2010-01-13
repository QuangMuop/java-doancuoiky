<%@page session="true" %>
<%@page import="Hotel.*, Agent.*, java.util.*" %>
<jsp:useBean id="hotelModel" scope="application" class="Agent.HotelModel" />

<div class="left-panel">
    <%
    ListHotel listHotel = hotelModel.getListHotel();
    for (int i = 0; i < listHotel.size(); i++) {
        Hotel h = listHotel.getHotels().get(i);
    %>
    <ul>
        <li>
        <a href="hotels?action=get-hotel-info&hid=<%= h.getId() %>"><%= h.getName() %></a>
        </li>
    </ul>
    <%
    }
    %>
</div>