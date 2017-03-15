(function(){
	'use strict';
	
	angular.module('mediaticApp.service')
	.controller('loginCtrl',function($scope, AuthentificationService){
		
		$scope.tryConnection = function(login,psw){
			AuthentificationService.connect(login,psw);
		}
		
		$scope.isConnected = function(){
			return AuthentificationService.isConnected();
		}
	})
})();

