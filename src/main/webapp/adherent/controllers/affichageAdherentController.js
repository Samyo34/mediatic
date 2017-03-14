(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent',[])
	.config(function($routeProvider){
		$routeProvider.when('/adherent/:id',{
			templateUrl:'../templates/affichageAdherent.html',
			controller:'affichageAdherentCtrl'
		})
	})
	.controller('affichageAdherentCtrl',function($scope,$routeParams,$rootScope){
		
	})
	
})();