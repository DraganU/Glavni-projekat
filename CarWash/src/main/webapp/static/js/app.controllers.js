carWashApp = angular.module('carWashApp.controllers', []);

carWashApp.controller('WashController', function($scope, $http, $location,
		$routeParams, washRestService) {

	
	// CHARTS -----------------------------------
	// BAR chart
	$scope.labels = ['Jan', 'Feb', 'March', 'April', 'May', 'June', 'July', 'August', 'Sep', 'Oct', 'Nov', 'Dec'];
	  $scope.series = ['Small Cars', 'Medium Cars', 'Big Cars'];

	  $scope.data = [
	    [65, 59, 80, 81, 56, 55, 40, 22, 10 , 80, 33, 140],
	    [28, 48, 40, 19, 86, 27, 90, 48, 28, 62, 9, 6],
	    [48, 28, 62, 9, 6, 87, 42, 65, 59, 80, 81, 56]
	    
	  ];
    
	 // PIE CHART
	  
	  $scope.labelsPie = ["Small-Cars", "Medium-Cars", "Big-Cars"];
	  $scope.dataPie = [300, 500, 100];
	
	
	
	// GET ALL Washes------------
	$scope.getWashes = function() {

		$http.get('api/washes').success(function(data) {
			$scope.washes = data;
			$scope.successMessage = 'Everything is ok.';
		}).error(function() {
			$scope.errorMessage = 'Oops, something went wrong!';
		});

	};

	// DELETE ------------------------------------
	$scope.deleteWash = function(wash, index) {
		washRestService.deleteWash(wash.id).success(function() {
			$scope.wash = wash;
			$scope.wash.splice(index, 1);
			$scope.succ = true;
			$scope.err = false;
		}).error(function() {
			$scope.wash = wash;
			$scope.succ = false;
			$scope.err = true;
		});
	};

	// SAVE -------------------------------------------------
	$scope.saveWash = function() {
		if ($scope.wash.id) {
			washRestService.saveWash($scope.wash).success(function() {
				$location.path('/washes');
			});
		} else {
			washRestService.saveWash($scope.wash).success(function() {
				$location.path('/washes');
			});
		}
	};

	// INIT ---------------------------------------
	$scope.initWash = function() {
		$scope.wash = {};
		if ($routeParams && $routeParams.id) {
			washRestService.getWash($routeParams.id).success(function(data) {
				$scope.wash = data;
			});
		}
	};

	// GET TRACKERS -----------------
	$scope.getTrackers = function() {

		$http.get('api/tracker').success(function(data) {
			$scope.trackers = data;
			$scope.successMessage = 'Everything is ok.';
		}).error(function() {
			$scope.errorMessage = 'Oops, something went wrong!';
		});
		
		$scope.getTotal = function(){
		    var total = 0;
		    angular.forEach($scope.trackers, function(item){
		    	total += item.wash.price;
            })
		    return total;
		}

	};
	//SAVE TRACKER --------------------
	$scope.saveTracker = function() {
		$scope.tracker = {}; 
		$scope.tracker.wash = $scope.washSelected;
		washRestService.saveTracker($scope.tracker).success(function() {
				$location.path('/');
			});
	};

});