<%@page session="true" %>
<%@page import="Hotel.HotelInfo, Agent.HotelModel, Agent.StartUpServlet, java.util.*" %>

<div class="left-panel">
    <%
    List<HotelInfo> hotels = StartUpServlet.listHotels;
    for (int i = 0; i < hotels.size(); i++ ) {
        HotelInfo h = hotels.get(i);
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