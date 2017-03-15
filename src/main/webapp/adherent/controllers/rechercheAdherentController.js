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
		
		$scope.adherents = [];
		ServiceUrl.getAdherents().then(function(adherents){
			$scope.adherents = adherents;
		});
		
		$scope.startSearch = function() {
			var params = {};
			if($scope.search.id != undefined)
			{
				params.id = $scope.search.id;
			}
			if($scope.search.nom != undefined)
			{
				params.nom = $scope.search.nom;
			}
			if($scope.search.prenom != undefined)
			{
				params.prenom = $scope.search.prenom;
			}
			if($scope.search.email != undefined)
			{
				params.email = $scope.search.email;
			}
			if($scope.search.nomOuPrenom != undefined)
			{
				params.texte = $scope.search.nomOuPrenom;
			}
			ServiceUrl.getAdherentsByParams(params).then(function(adherents){
				$scope.adherents = adherents;
			});
		}
	})
	
})();