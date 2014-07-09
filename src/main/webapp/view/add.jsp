<%@ page contentType="text/html; UTF-8" language="java" %>

<html>
<head>
    <title>Add Record</title>
</head>

<body>
    <h1>Add record</h1>

    <form method="post" action="add.do">
        <table>
            <tr>
                <td>id:</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>note:</td>
                <td><input type="text" name="note"></td>
            </tr>
            <tr>
                <td><input type="submit" value="send"></td>
                <td><input type="reset" value="clean"></td>
            </tr>
        </table>
    </form>
</body>

</html>