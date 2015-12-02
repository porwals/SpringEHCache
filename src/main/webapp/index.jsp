<!DOCTYPE html>
<html ng-app="demoApp" lang="english">
<head>
<meta charset=UTF-8>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/greeting.css">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<title>Demo App</title>
</head>
<body ng-controller="homePageCtrl">
<div>
<h1 class="greeting"> Welcome To Hateos</h1>
<input type="text" ng-model="test"/>{{test}}
<a href="">Click Here For Organization</a>

</div>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/controllers/homePageController.js"></script>
</body>
</html>
