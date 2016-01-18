basketballApp = angular.module('basketballApp.services', []);

basketballApp.service('playerRestService', function($http) { 
	
// ---- Player service
	
    this.getPlayers = function(request_params) {
		return $http.get('api/players/', {params : request_params});
    };
   
    this.getPlayer = function(id) {
		return $http.get('api/players/' + id)
    };
    
    this.getStat = function(id) {
		return $http.get('api/stats/' + id)
    };
    
    this.getTeams = function(request_params) {
		return $http.get('api/teams/', {params : request_params});
    };
    
    this.getTeam = function(id) {
		return $http.get('api/teams/' + id);
    };
    
    this.saveTeam = function (team) {
    	return $http.post('api/teams' , team)
    };
    
});