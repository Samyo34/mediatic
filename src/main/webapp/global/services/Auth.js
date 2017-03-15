angular.module('mediaticApp.service').factory('AuthentificationService', function($http, ServiceUrl){
	
	var AuthentificationService = {};

	var connected = false;
	var defaut = 'Basic';

	if(false){
		console.warn('Connexion automatique !!')
		connected = true;
		defaut = 'Basic YXplOmF6ZQ==';
	}

	$http.defaults.headers.common['Authorization'] = defaut;

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
			return true;
		}, function(){
			connected = false;
			$http.defaults.headers.common['Authorization'] = 'Basic';
			return false;
		});
	};

	AuthentificationService.isConnected = function(){
		return connected;
	};

	return AuthentificationService;

});