<!doctype html>
<html>
<head>
<title>Foglio Ore Home</title>
<jsp:include page="common.jsp"></jsp:include>
<script src="home.js"></script>
</head>

<body>
	<div ng-app="logon" ng-controller="homeIndexController" class="popupMini">
		<p>Benvenuto {{user.nome}} !!</p>
		<div class="error">{{error.message}}</div>
	</div>
</body>
</html>
