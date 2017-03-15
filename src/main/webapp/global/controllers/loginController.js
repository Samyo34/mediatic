(function(){
	'use strict';
	
	angular.module('mediaticApp.service')
	.controller('mainCtrl',function($scope, AuthentificationService){
		
		$scope.tryConnection = function(login,psw){
			AuthentificationService.connect(login,psw);
		}
		
		$scope.disconnect = function(){
			AuthentificationService.disconnect();
		}
		
		$scope.isConnected = function(){
			return AuthentificationService.isConnected();
		}
	})
})();

