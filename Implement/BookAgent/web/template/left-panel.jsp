<%@page session="true" %>
<%@page import="Hotel.*, Agent.*, java.util.*" %>


<div class="left-panel">
    <ul>
        <%
            HotelModel hotelModel = new HotelModel();
            ListHotel listHotel = hotelModel.getListHotel();
            for (int i = 0; i < listHotel.size(); i++) {
                Hotel h = listHotel.getHotels().get(i);
        %>

        <li>
            <a href="hotels?action=get-hotel-info&hid=<%= h.getId()%>"><%= h.getName()%></a>
        </li>

        <%
            }
        %>
    </ul>
</div>