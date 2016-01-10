wafepaApp = angular.module('wafepaApp.routes', ['ngRoute']);

wafepaApp.config (['$routeProvider', function($routeProvider) {
	
	 $routeProvider
       .when('/', {
           templateUrl : 'static/html/home.html'
       })
       
       // -------------- ACTIVITY -------------------------
       .when('/activities', {
           templateUrl : 'static/html/activities.html',
           controller: 'ActivityController'
       })      
       
       .when('/activities/view/:id', {
			templateUrl : 'static/html/activity.html',
			controller : 'ActivityController'
		})
		
		.when('/activities/add', {
			templateUrl : 'static/html/addEditActivity.html',
			controller : 'ActivityController'
		})
		.when('/activities/edit/:id', {
			templateUrl : 'static/html/addEditActivity.html',
			controller : 'ActivityController'
		})
		.when('/activities/:activityId/logsActivity', {
           templateUrl : 'static/html/logsActivity.html',
           controller: 'LogController'
       })
	
		// ------------ USER ---------------------
		.when('/users', {
       	templateUrl : 'static/html/users.html',
           controller: 'ActivityController'   
       })
       .when('/users/view/:id', {
			templateUrl : 'static/html/user.html',
			controller : 'ActivityController'
		})
      
       .when('/users/add', {
			templateUrl : 'static/html/addEditUser.html',
			controller : 'ActivityController'
		})
		
		.when('/users/edit/:id',{
			templateUrl : 'static/html/addEditUser.html',
			controller : 'ActivityController'
		})
		.when('/users/:userId/logsUser', {
           templateUrl : 'static/html/logsUser.html',
           controller: 'LogController'
       })
		
		// -------------- LOG ---------------------
		.when('/logs', {
			templateUrl : 'static/html/logs.html',
			controller : 'LogController'
		})
       .when('/logs/add', {
			templateUrl : 'static/html/AddEditLog.html',
			controller : 'LogController'
		})
   
       .otherwise ( {
           redirectTo: '/'
       });
}]);