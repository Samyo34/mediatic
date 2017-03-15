(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/medias',{
			templateUrl:'/media/templates/rechercheMedia.html',
			controller:'RechercheMediaCtrl'
		})
	})
	.controller('RechercheMediaCtrl',function($scope, $routeParams, $rootScope, ServiceUrl){
		$rootScope.title = "Recherche Médias";
		
		$scope.sizeArrayMedia = 10;
		$scope.sizeMaxMedia = false;
		
		$scope.medias = [];
		ServiceUrl.getMedias().then(function(medias){
			$scope.medias = medias;
		});
		
		$scope.sortedId = false;
		
		$scope.sortId = function() {
			$scope.sortedId = !$scope.sortedId;
			var params = {tri: "id"};
			if($scope.sortedId)
			{
				params.tri = "-id";
			}
			ServiceUrl.getMediasByParams(params).then(function(medias){
				$scope.medias = medias;
			});
		}
		
		$scope.sortedTitre = false;
		
		$scope.sortTitre = function() {
			$scope.sortedTitre = !$scope.sortedTitre;
			var params = {tri: "titre"};
			if($scope.sortedTitre)
			{
				params.tri = "-titre";
			}
			ServiceUrl.getMediasByParams(params).then(function(medias){
				$scope.medias = medias;
			});
		}
		
		$scope.sortedAuteur = false;
		
		$scope.sortAuteur = function() {
			$scope.sortedAuteur = !$scope.sortedAuteur;
			var params = {tri: "auteur"};
			if($scope.sortedAuteur)
			{
				params.tri = "-auteur";
			}
			ServiceUrl.getMediasByParams(params).then(function(medias){
				$scope.medias = medias;
			});
		}
		
		$scope.startSearch = function() {
			var params = {};
			if($scope.search.titre != undefined)
			{
				params.titre = $scope.search.titre;
			}
			if($scope.search.auteur != undefined)
			{
				params.auteur = $scope.search.auteur;
			}
			if($scope.search.type != undefined)
			{
				params.type = $scope.search.type;
			}
			ServiceUrl.getMediasByParams(params).then(function(medias){
				$scope.medias = medias;
			});
		}
		
		$scope.addSize = function(){
			$scope.sizeArrayMedia += 5;
			if($scope.sizeArrayMedia >= $scope.medias.length){
				$scope.sizeMaxMedia = true;
			}
		}
		
	})
	
})();