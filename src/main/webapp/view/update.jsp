<%--
  Created by IntelliJ IDEA.
  User: rgordeev
  Date: 14.07.14
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update record</title>
</head>
<body>
<jsp:useBean id="record" scope="request" type="model.Record"/>
<h1>Update the Record</h1>

<form method="post" action="update.do">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="text" name="id" readonly="true" value="${record.id}"></td>
        </tr>
        <tr>
            <td>note:</td>
            <td><input type="text" name="note" value="${record.note}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="send"></td>
            <td><input type="reset" value="clean"></td>
        </tr>
    </table>
</form>

</body>
</html>
