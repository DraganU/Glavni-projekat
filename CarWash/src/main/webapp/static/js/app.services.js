carWashApp = angular.module('carWashApp.services', []);


carWashApp.service('washRestService', function($http) {
	
	this.getWash = function(id) {
		return $http.get('api/washes/' + id);
    };
	
	this.deleteWash = function(id) {
		return $http.delete('api/washes/' + id);
    };
    
    this.saveWash = function(wash) {
		if (wash.id) {
			return $http.put('api/washes/'+ wash.id, wash)
		}else{
			return $http.post('api/washes', wash)
    	}
    };
    
    this.saveTracker = function(tracker) {
			return $http.post('api/tracker', tracker)
    };
    
});