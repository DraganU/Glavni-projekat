wafepaApp= angular.module ('wafepaApp.controllers', []);

// ----------------------------------
//  LOG CONTROLLER
// ----------------------------------
wafepaApp.controller('LogController', function($scope, $http, $location, $routeParams) {
	
	
//  CURRENT TIME ---------------------
	$scope.date = new Date();
		
//  DATEPICKER ---------------------------------------------
	 $scope.today = function() {
		    $scope.dt = new Date();
		  };
	$scope.today();

	$scope.clear = function () {
		  $scope.dt = null;
	};
		  // Disable weekend selection
	$scope.disabled = function(date, mode) {
		 return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
	};

	$scope.toggleMin = function() {
		 $scope.minDate = $scope.minDate ? null : new Date();
	};
	$scope.toggleMin();
	$scope.maxDate = new Date(2020, 5, 22);

	$scope.open = function($event) {
		  $scope.status.opened = true;
	};

	$scope.setDate = function(year, month, day) {
		  $scope.dt = new Date(year, month, day);
	};

	$scope.dateOptions = {formatYear: 'yy',startingDay: 1};
	$scope.formats = ['yyyy-MM-dd', 'dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	$scope.format = $scope.formats[0];
	$scope.status = {opened: false};
		  
	var tomorrow = new Date();
	tomorrow.setDate(tomorrow.getDate() + 1);
	var afterTomorrow = new Date();
	afterTomorrow.setDate(tomorrow.getDate() + 2);
	$scope.events =[{
		        date: tomorrow,
		        status: 'full'
		      },{
		        date: afterTomorrow,
		        status: 'partially'
		      }];

	$scope.getDayClass = function(date, mode) {
		 if (mode === 'day') {
		     var dayToCheck = new Date(date).setHours(0,0,0,0);

		     for (var i=0;i<$scope.events.length;i++){
		        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

		        if (dayToCheck === currentDay) {
		          return $scope.events[i].status;
		        }
		      }
		    }

	return '';
	};
// --------------------- DATEPICKER ENDS-----------------------
	

// LOG ------------------
	$scope.initLog = function() {
		$scope.log = {}; 
		var request_params = {}	;
		request_params.page = 0;
		request_params.pageSize = 5;
		
		$http.get('api/activities', {params: request_params})
			.success(function(data) {	
				$scope.activities = data;
			});
		$http.get('api/users', {params: request_params})
		.success(function(data) {	
			$scope.users = data;
		});
	};
	
	$scope.saveLog = function() { 
		$scope.log.activity = $scope.activitySelected;
		$scope.log.user = $scope.userSelected;
		$scope.log.date = $scope.dt;
		$scope.sat = Number($scope.x*60);
		$scope.min = Number($scope.y);
		if($scope.min > 59){
			alert("Minutes cant be bigger than 59");
		}else {
		$scope.log.duration = $scope.sat + $scope.min;
		$http.post('api/logs', $scope.log)
			.success (function (){
				$location.path('/');	
			})
			.error(function() {
				$scope.errr = true;
			});
		}
	};
	
	$scope.getLogs = function() {
		if ($routeParams && $routeParams.activityId) {
			var request_params = {};
			request_params['activityId'] = $routeParams.activityId;
			request_params['userId'] = $routeParams.userId;
			
			$http.get('api/logs', { params : request_params})
					.success(function(data) {
						$scope.logs = data;
						$scope.sat = parseInt($scope.log.duration / 60);
						$scope.minut = $scope.log.duration % 60;
						console.log($scope.minut);
						$scope.successMessage = 'Everything is ok.';
						$scope.logs.length === 0 ? $scope.curLog = "" : $scope.curLog = $scope.logs[0];
					});
		
		}else if($routeParams && $routeParams.userId){
			var request_params = {};
			request_params['activityId'] = $routeParams.activityId;
			request_params['userId'] = $routeParams.userId;
			
			$http.get('api/logs', { params : request_params})
				.success(function(data) {
					$scope.logs = data;
					$scope.successMessage = 'Everything is ok.';
					$scope.logs.length === 0 ? $scope.curLog = "" : $scope.curLog = $scope.logs[0];
				})
				.error(function() {
					$scope.errorMessage = 'Oops, something went wrong!';
				});
		
		}else {
			var request_params = {};
			request_params['activityId'] = $routeParams.activityId;
			request_params['userId'] = $routeParams.userId;
			$http.get('api/logs' , { params : request_params})
				.success(function(data) {
					$scope.logs = data;
					$scope.successMessage = 'Everything is ok.';
					$scope.logs.length === 0 ? $scope.curLog = "" : $scope.curLog = $scope.logs[0];
				})
				.error(function() {
					$scope.errorMessage = 'Oops, something went wrong!';
				});
		}		
	};	
});
//-------------------------------------------------------------------------------------
//  ACTIVITY CONTROLLER
//---------------------------------------------------------------------------------------
wafepaApp.controller('ActivityController', function($scope, $http, $location, $routeParams, activityRestService, $interval) {
	
	$scope.page=0;  // current page
	$scope.pageSize=5; // Items per page
	
	
	
	//TIMER
	$scope.format = 'ss'; //minutes and seconds format 
	 
	$scope.starttimer = function(){
		$scope.timer = 5000;
		console.log($scope.timer);
		$interval(function(){
				$scope.timer;
				$scope.timer -=1000; //starttime is equal to starttime - 1 second
				if($scope.timer === 0){
					$scope.saveActivity();
				}
				console.log($scope.timer);
				},1000, 5);
	    //return start;
	 };
	 $scope.stopTimer = function () {
          //Cancel the Timer.
          if (angular.isDefined($scope.timer)) {
              $interval.cancel($scope.timer);
              $scope.timer = undefined;
              console.log($scope.timer);
          }
      };
      
    
	
// PAGINACIJA -------------------------------
	$scope.getArr=function(n){
        var arr = [];
        for (var i = 1; i <= n; i++) {
            arr.push(i);
        }
        return arr;
	};
	
	
// GETALL ----------------------------
	$scope.getActivities = function() {
		// search
		var request_params = {}	;
		if ($scope.search) {
			request_params.field = 'name';
			request_params.value = $scope.search;
		}
		request_params.page = $scope.page;
		request_params.pageSize = $scope.pageSize;
		
		activityRestService.getActivities(request_params)
				.success(function(data, status, headers) {	
					$scope.activities = data;
					$scope.successMessage = 'Everything is ok.';
					$scope.totalPages= headers() ['total-pages']
					$scope.totalElements = headers () ['total-elements']
				})
				.error(function() {
					$scope.errorMessage = 'Oops, something went wrong!';
				});
	};
	
// DELETE --------------------------------------------
	$scope.deleteActivity = function(activity, index) {
		
		activityRestService.deleteActivity(activity)
				.success(function() {
					$scope.activity = activity;
					$scope.activities.splice(index, 1);
					$scope.succ = true;
					$scope.err= false;
					
				})
				.error(function() {
					$scope.succ = false;
					$scope.err = true;
					$scope.activity = activity;
				});
	};
$scope.deleteActivityEdit = function(activity) {
		
		activityRestService.deleteActivity(activity)
				.success(function() {
					$scope.activity = activity;
					$location.path('/activities');
					/*$scope.succ = true;
					$scope.err= false;*/
					
				})
				.error(function() {
					$scope.succ = false;
					$scope.err = true;
					$scope.activity = activity;
				});
	};
// HIDEACTIVIY --------------------------------------------
	 $scope.hideActivity = function(activities, index) {
		 $scope.activity = activities[index];
		 $scope.activity.hidden = !$scope.activity.hidden;
		 activityRestService.hideActivity($scope.activity)
			.success(function() {
				$location.path('/activities');
			})
			.error(function() {
				alert('something went wrong!');
			});
	  };
	  
// INIT -----------------------------------------------------
	$scope.initActivity = function() {$scope.activity = {}; 
		if ($routeParams && $routeParams.id) {
			activityRestService.getActivity($routeParams.id)
				.success(function(data) {
					$scope.activity = data;
				});
		}
	};
// SAVE ---------------------------------------------------
	
	$scope.saveActivity = function() { 
		if ($scope.activity.id) {
			activityRestService.saveActivity($scope.activity)
			.success(function() {
					$location.path('/activities');
			});
		}
		else {
			for (var akt in $scope.activities){
				$scope.x = $scope.activities[akt];
				if ($scope.activity.name === $scope.x.name){
					$scope.errori = true;
				}
			}
			//console.log("scope errori" + $scope.errori);
			if ($scope.errori){
					alert("Molim unesite drugo ime");
			}else 
				activityRestService.saveActivity($scope.activity)
				.success(function() {
					$location.path('/activities');
				});
			
		}
	};
	
	$scope.changePage = function (page) {
		$scope.page = page;
		$scope.getActivities();
	}
//------------------------------------------------------------------
//  USER 
//------------------------------------------------------------------
	
	
// GETALL -------------------
	$scope.getUsers = function() {
		var request_params = {}
		if ($scope.search ){ 
			request_params.email= $scope.search;
		}
		
		request_params.page = $scope.page;
		request_params.pageSize = $scope.pageSize;
		
		activityRestService.getUsers(request_params)
			.success(function(data, status, headers) {
				$scope.users = data;
				$scope.successMessage = 'Everything is ok.';
				$scope.totalPages= headers() ['total-pages']
				$scope.totalElements = headers () ['total-elements']
			})
			.error(function() {
				$scope.errorMessage = 'Oops, something went wrong!';
			});
	};
// DELETE ------------------------------------
	$scope.deleteUser = function(user, index) {
		activityRestService.deleteUser(user.id)
				.success(function() {
					$scope.user = user;
					$scope.users.splice(index, 1);
					$scope.succ = true;
					$scope.err= false;
				})
				.error(function() {
					$scope.user = user;
					$scope.succ = false;
					$scope.err = true;
				});
	};
// INIT -------------------------------------------
	$scope.initUser = function() {
		$scope.user = {}; 
		if ($routeParams && $routeParams.id) {
			activityRestService.getUser($routeParams.id)
			.success(function(data) {
				$scope.user = data;
			});
		}
	};
// SAVE ----------------------------------------------------
	$scope.saveUser = function() { 
		if ($scope.user.id) {
			activityRestService.saveUser($scope.user)
			.success(function() {
				$location.path('/users');
			});
		}
		else {
			activityRestService.saveUser($scope.user)
			.success(function() {
				$location.path('/users');
			});
		}
	};
	$scope.changePage2 = function (page) {
		$scope.page = page;
		$scope.getUsers();
	}
	
});