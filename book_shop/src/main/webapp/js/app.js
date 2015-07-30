var app = angular.module('shopApp', [ 'ngResource', 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'js/views/shopMainList.html',
		controller : 'bookController',
		controllerAs : 'bookCtrl'
	}).when('/book/:bookId', {
		templateUrl : 'js/views/bookDetail.html',
		controller : 'bookDetailController',
		controllerAs : 'bookDetailCtrl'
	}).otherwise({
		redirectTo : '/'
	});
} ]);
