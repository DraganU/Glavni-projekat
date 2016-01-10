wafepaApp = angular.module('wafepaApp.services', []);

wafepaApp.service('activityRestService', function($http) { 
	
// ---- ACTIVITY / USER SERVICE
	this.getActivity = function(id) {
		return $http.get('api/activities/' + id);
    };
	this.deleteActivity = function(activity) {
		return $http.put('api/activities/' + activity.id, activity);
    };
    this.hideActivity = function(activity) {
		return $http.put('api/activities/' + activity.id, activity);
    };
    this.getActivities = function(request_params) {
		return $http.get('api/activities/', {params : request_params});
    };
    this.saveActivity = function(activity) {
		if (activity.id) {
			return $http.put('api/activities/' + activity.id, activity);
		}else{
			return $http.post('api/activities', activity);
    	}
    };
    // USER 
    this.getUsers = function(request_params) {
		return $http.get('api/users' , {params : request_params});
    };
    this.deleteUser = function(id) {
		return $http.delete('api/users/' + id);
    };
    this.getUser = function(id) {
		return $http.get('api/users/' + id)
    };
    this.saveUser = function(user) {
		if (user.id) {
			return $http.put('api/users/'+ user.id, user)
		}else{
			return $http.post('api/users', user)
    	}
    };
    
});