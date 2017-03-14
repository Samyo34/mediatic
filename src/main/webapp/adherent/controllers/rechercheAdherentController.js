(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent')
	.config(function($routeProvider){
		$routeProvider.when('/adherents',{
			templateUrl:'/adherent/templates/rechercheAdherent.html',
			controller:'RechercheAdherentCtrl'
		})
	})
	.controller('RechercheAdherentCtrl',function($scope,$routeParams,$rootScope){
		$rootScope.title = "Recherche Adhérent";
	})
	
})();