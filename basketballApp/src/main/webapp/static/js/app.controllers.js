basketballApp = angular.module('basketballApp.controllers', []);

basketballApp.controller('PlayerController', function($scope, $http, $location,
		$routeParams, playerRestService) {

	$scope.page = 0; // current page
	$scope.pageSize = 50; // Items per page

	$scope.getArr = function(n) {
		var arr = [];
		for (var i = 1; i <= n; i++) {
			arr.push(i);
		}
		return arr;
	};

	// GETALL ----------------------------
	$scope.getPlayers = function() {
		var request_params = {}
		request_params.page = $scope.page;
		request_params.pageSize = $scope.pageSize;

		playerRestService.getPlayers(request_params).success(
				function(data, status, headers) {
					$scope.players = data;
					$scope.totalPages = headers()['total-pages']
					$scope.totalElements = headers()['total-elements']
					$scope.successMessage = 'Everything is ok.';
				}).error(function() {
			$scope.errorMessage = 'Oops, something went wrong!';
		});
	};

	// GETONE -----------------------------
	$scope.initPlayer = function() {
		$scope.player = {};
		if ($routeParams && $routeParams.id) {
			playerRestService.getPlayer($routeParams.id).success(
					function(data) {
						$scope.player = data;
					});
		}
	};

	$scope.initStat = function() {
		$scope.player = {};
		if ($routeParams && $routeParams.id) {
			playerRestService.getPlayer($routeParams.id).success(
					function(data) {
						$scope.player = data;
						$scope.stat = {};
						playerRestService.getStat($scope.player.stats).success(
								function(data) {
									$scope.stat = data;
								});
					});
		}
	};
	
	// TEAMS ====================================================
	//===========================================================
	// GET ALL
	$scope.getTeams = function() {
		var request_params = {}
		request_params.page = $scope.page;
		request_params.pageSize = $scope.pageSize;

		playerRestService.getTeams(request_params).success(
				function(data, status, headers) {
					$scope.teams = data;
					$scope.totalPages = headers()['total-pages']
					$scope.totalElements = headers()['total-elements']
					$scope.successMessage = 'Everything is ok.';
				}).error(function() {
			$scope.errorMessage = 'Oops, something went wrong!';
		});
	};	
	// SAVE =====================================================
	$scope.saveTeam = function() {
		var team2 = {}
		team2.name = $scope.team.name;
		var player1 = '';
		player1 = $scope.team.player1.firstname + " " + $scope.team.player1.lastname + ", " + $scope.team.player1.team;
		team2.player1 = player1;
		
		var player2 = '';
		player2 = $scope.team.player2.firstname + " " + $scope.team.player2.lastname + ", " + $scope.team.player2.team;
		team2.player2 = player2;
		
		var player3 = '';
		player3 = $scope.team.player3.firstname + " " + $scope.team.player3.lastname + ", " + $scope.team.player3.team;
		team2.player3 = player3;
		
		var player4 = '';
		player4 = $scope.team.player4.firstname + " " + $scope.team.player4.lastname + ", " + $scope.team.player4.team;
		team2.player4 = player4;
		
		var player5 = '';
		player5 = $scope.team.player5.firstname + " " + $scope.team.player5.lastname + ", " + $scope.team.player5.team;
		team2.player5 = player5;
		
		playerRestService.saveTeam(team2)
		.success(function() {
			$location.path('/teams');
		});
	};
	

	// CHANGE PAGE -----------------------
	$scope.changePage2 = function(page) {
		$scope.page = page;
		$scope.getPlayers();
	}

});