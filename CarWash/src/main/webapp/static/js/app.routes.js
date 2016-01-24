carWashApp = angular.module('carWashApp.routes', [ 'ngRoute' ]);

carWashApp.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'static/html/home.html'
	})

	.when('/washes', {
		templateUrl : 'static/html/washes.html',
		controller : 'WashController'
	})

	.when('/washes/add', {
		templateUrl : 'static/html/addEditWash.html',
		controller : 'WashController'
	})

	.when('/washes/edit/:id', {
		templateUrl : 'static/html/addEditWash.html',
		controller : 'WashController'
	})
	
	.when('/tracker/add', {
		templateUrl : 'static/html/addTracker.html',
		controller : 'WashController'
	})
	
	.when('/reports', {
		templateUrl : 'static/html/reports.html',
		controller : 'WashController'
	})
	
	.when('/analytics', {
		templateUrl : 'static/html/analytics.html',
		controller : 'WashController'
	})

	.otherwise({
		redirectTo : '/'
	});

} ]);