var app = angular.module("myapp", []);

app.controller("homeIndexController", function($scope, $http) {

	$scope.login = function() {

		$http.post('./user/logon', $scope.post).success(function(data) {
			$scope.user = data.retVal;
			$scope.error = data.exception.message;
		}).error(function(data, status) {
			$scope.error = data.message || " Request failed " || status;
		});
	}
});