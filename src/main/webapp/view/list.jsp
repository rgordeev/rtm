<%@ page import="model.Record" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remember the milk</title>
</head>

<body>

<jsp:useBean id="storage" scope="request" type="storage.StorageService">

</jsp:useBean>

    <table>
        <thead>
            <tr>
                <td>id</td>
                <td>note</td>
                <td></td>
                <td></td>
            </tr>
        </thead>

        <tbody>
<%
    for (Record record : storage.list())
    {
%>
            <tr>
                <td><%= record.getId() %>  </td>
                <td><%= record.getNote() %></td>
                <td><a href="update.do?id=<%= record.getId() %>">update</a></td>
                <td><a href="delete.do?id=<%= record.getId() %>">remove</a></td>
            </tr>
<%
    }
%>
        </tbody>

    </table>
</body>

</html>