<%--
  Created by IntelliJ IDEA.
  User: rgordeev
  Date: 14.07.14
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en" ng-app="rtm">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My AngularJS App</title>
    <link rel="stylesheet" href="css/app.css"/>
    <link rel="stylesheet" href="css/bootstrap/bootstrap-responsive.min.css"/>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css"/>
</head>
<body>
<ul class="menu">
    <li><a href="#/record-list">record-list</a></li>
    <li><a href="#/record-detail/1">record-detail/1</a></li>
    <li><a href="#/record-creation">record-creation</a></li>
</ul>

<div ng-view></div>

<!-- JQuery ================================================================ -->
<script src="js/jquery/jquery-2.0.3.js"></script>

<!-- Bootstrap ============================================================= -->
<script src="js/bootstrap/bootstrap.js"></script>

<!-- AngularJS ============================================================= -->
<script src="js/angular/angular.js"></script>
<script src="js/angular/angular-resource.js"></script>

<!-- AngularJS App Code ==================================================== -->
<script src="js/app.js"></script>
<script src="js/services.js"></script>
<script src="js/controllers.js"></script>

</body>
</html>
