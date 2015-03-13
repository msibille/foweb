<!doctype html>
<html>
<head>
<title>Foglio Ore Login</title>
<jsp:include page="common.jsp"></jsp:include>
<script src="index.js"></script>
</head>

<body>
	<div ng-app="logon" ng-controller="homeIndexController" class="popupMini">
		<div class="center">Benvenuto su Foglio Ore WEB</div>
		<div class="spacerMini"></div>
		<div class="labelMidi">User</div>
		<div class="field">
			<input type="text" ng-model="post.user" />
		</div>
		<div class="labelMidi">Password</div>
		<div class="field"><input type="password" ng-model="post.password" /></div>
		<div class=center>
			<input type="button" ng-click="login()" value="login" />
		</div>
		<div class="error">{{error.message}}</div>
	</div>
</body>
</html>
