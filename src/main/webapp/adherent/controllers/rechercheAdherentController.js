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
		
		$scope.sizeArrayAd = 10;
		$scope.sizeMaxAd = false;
		
		$scope.adherents = [];
		ServiceUrl.getAdherents().then(function(adherents){
			$scope.adherents = adherents;
		});
		
		$scope.addSize = function(){
			$scope.sizeArrayAd += 20;
			if($scope.sizeArrayAd >= $scope.adherents.length){
				$scope.sizeMaxAd = true;
			}
		}
		
		
		
	})
	
})();