(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/media/:id',{
			templateUrl:'/media/templates/affichageMedia.html',
			controller:'AffichageMediaCtrl'
		})
	})
	.controller('AffichageMediaCtrl',function($scope,$routeParams,$rootScope, ServiceUrl){
		$rootScope.titre = 'Affichage Media';
		
		$scope.datas = [] ;
		$scope.updateMedia ={};
		ServiceUrl.getMediaById($routeParams.id).then(function(data){
			$scope.datas = data;
			$scope.emprunteurs = $scope.datas.emprunteurs;
		})
		$scope.buttonUpdate = false;
		
		
		
		$scope.newUpdateMedia = function(){
			$scope.updateMedia.id = $routeParams.id;
			ServiceUrl.updateMedia($scope.updateMedia);
			ServiceUrl.getMediaById($routeParams.id).then(function(data){
				$scope.datas = data;
				$scope.emprunteurs = $scope.datas.emprunteurs;
			})
			$scope.buttonUpdate = !$scope.buttonUpdate;
		}
		
		$scope.addingEmprunt = false;
		$scope.emprunt = {};
		
		$scope.setAddingEmprunt =function(){
			$scope.addingEmprunt = !$scope.addingEmprunt;
		}
		
		$scope.isAddingEmprunt = function(){
			return $scope.addingEmprunt;
		}
		
		$scope.addEmprunt = function(){
			ServiceUrl.getAdherentsByParams({nom:$scope.emprunt.nom,prenom:$scope.emprunt.prenom}).then(function(data){
				ServiceUrl.addEmpruntMedia(data[0].id,$routeParams.id,$scope.emprunt.date);
				$scope.addingEmprunt = false;
				ServiceUrl.getMediaById($routeParams.id).then(function(data){
					$scope.datas = data;
					$scope.emprunteurs = $scope.datas.emprunteurs;
				})
			});
		}
		
	})
})();