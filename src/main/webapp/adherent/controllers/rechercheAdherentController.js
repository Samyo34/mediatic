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
		$scope.sortedId = false;
		
		$scope.sortId = function() {
			$scope.sortedId = !$scope.sortedId;
			var params = {tri: "id"};
			if($scope.sortedId)
			{
				params.tri = "-id";
			}
			ServiceUrl.getAdherentsByParams(params).then(function(adherents){
				$scope.adherents = adherents;
			});
		}
		
		$scope.sortedPrenom = false;
		
		$scope.sortPrenom = function() {
			$scope.sortedPrenom = !$scope.sortedPrenom;
			var params = {tri: "prenom"};
			if($scope.sortedPrenom)
			{
				params.tri = "-prenom";
			}
			ServiceUrl.getAdherentsByParams(params).then(function(adherents){
				$scope.adherents = adherents;
			});
		}
		
		$scope.sortedNom = false;
		
		$scope.sortNom = function() {
			$scope.sortedNom = !$scope.sortedNom;
			var params = {tri: "nom"};
			if($scope.sortedNom)
			{
				params.tri = "-nom";
			}
			ServiceUrl.getAdherentsByParams(params).then(function(adherents){
				$scope.adherents = adherents;
			});
		}
		
		$scope.sortedEmail = false;
		
		$scope.sortEmail = function() {
			$scope.sortedEmail = !$scope.sortedEmail;
			var params = {tri: "email"};
			if($scope.sortedEmail)
			{
				params.tri = "-email";
			}
			ServiceUrl.getAdherentsByParams(params).then(function(adherents){
				$scope.adherents = adherents;
			});
		}
		
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