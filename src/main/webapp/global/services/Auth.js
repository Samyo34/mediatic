angular.module('mediaticApp.service').factory('AuthentificationService', function($http, ServiceUrl, $cookies){
	
	var AuthentificationService = {};

	var connected = true;
	var defaut = 'Basic';

//	if($cookies.get('myFavorite') !== undefined){
//		connected = true;
//		$http.defaults.headers.common['Authorization'] = $cookies.get('myFavorite');
//	} else {
//		connected = false;
//		$http.defaults.headers.common['Authorization'] = defaut;
//	}
	

	AuthentificationService.connect = function(login, password){
		var auth = 'Basic ' + btoa(login+':'+password);
		var config = {
			headers : {
				'Authorization' : auth
			}
		};
		
		return $http.get(ServiceUrl.getConnection(), config).then(function(){
			connected = true;
			$http.defaults.headers.common['Authorization'] = auth;
			$cookies.put('myFavorite', auth);
			return true;
		}, function(){
			AuthentificationService.disconnect();
			return false;
		});
	};
	
	AuthentificationService.disconnect = function(){
		connected = false;
		$cookies.remove('myFavorite');
		$http.defaults.headers.common['Authorization'] = 'Basic';
	}
	
	AuthentificationService.isConnected = function(){ 
		return connected;
	};

	return AuthentificationService;

});