<!doctype html>
<html>
<head>
<title>Foglio Ore Login</title>
<jsp:include page="common.jsp"></jsp:include>
<script src="index.js"></script>
</head>

<body>
	<div ng-app="myapp" ng-controller="homeIndexController">
		<p>Benvenuto {{user.nome}} !!</p>
		<div>
			User <input type="text" ng-model="post.user" />
		</div>
		<div>
			Password <input type="password" ng-model="post.password" />
		</div>
		<div>
			<input type="button" ng-click="login()" value="login" />
		</div>
		<div>{{error}}</div>

	</div>
</body>
</html>
