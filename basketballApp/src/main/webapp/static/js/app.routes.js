basketballApp = angular.module('basketballApp.routes', [ 'ngRoute' ]);

basketballApp.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'static/html/home.html'
	})

	//PLAYER ----------------
	.when('/players', {
		templateUrl : 'static/html/players.html',
		controller : 'PlayerController'
	})

	.when('/players/:id', {
		templateUrl : 'static/html/player.html',
		controller : 'PlayerController'
	})

	//TEAM ---------------------
	.when('/teams/add', {
		templateUrl : 'static/html/createTeam.html',
		controller : 'PlayerController'
	})
	
	.when('/teams', {
		templateUrl : 'static/html/teams.html',
		controller : 'PlayerController'
	})

	.when('/teams/:id', {
		templateUrl : 'static/html/team.html',
		controller : 'PlayerController'
	})

	// USER ----------------------
	.when('/users', {
		templateUrl : 'static/html/users.html',
		controller : 'PlayerController'
	})
	
	// STATS ----------------------
	.when('/stats', {
		templateUrl : 'static/html/stats.html',
		controller : 'PlayerController'
	})

	.otherwise({
		redirectTo : '/'
	});

} ]);