<%@page session="true" %>
<%@page import="Hotel.*, Agent.*, java.util.*" %>


<div class="left-panel">
    <%
    HotelModel hotelModel = new HotelModel();
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