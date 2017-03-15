(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent')
	.config(function($routeProvider){
		$routeProvider.when('/adherents',{
			templateUrl:'/adherent/templates/rechercheAdherent.html',
			controller:'RechercheAdherentCtrl'
		})
	})
	.controller('RechercheAdherentCtrl',function($scope, $routeParams, $rootScope, ServiceUrl){
		$rootScope.title = "Recherche Adhérents";

		$scope.currentDate = new Date();
		
		$scope.sizeArray = 5;
		
		$scope.adherents = [];
		ServiceUrl.getAdherents().then(function(adherents){
			console.log(adherents);
			$scope.adherents = adherents;
		});
		
		$scope.addSize = function(){
			$scope.sizeArray += 5;
		}
		
		
		
	})
	
})();