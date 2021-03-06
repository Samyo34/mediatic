(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/media/:id',{
			templateUrl:'./media/templates/affichageMedia.html',
			controller:'AffichageMediaCtrl'
		})
	})
	.controller('AffichageMediaCtrl',function($scope,$routeParams,$rootScope, ServiceUrl){
		$rootScope.titre = 'Affichage Média';
		$rootScope.activeLink('medias');
		
		$scope.datas = [] ;
		$scope.updateMedia ={};
		$scope.buttonUpdate = false;
		$scope.sizeArrayMedia = 10;
		$scope.sizeMaxMedia = false;
		
		ServiceUrl.getMediaById($routeParams.id).then(function(data){
			$scope.datas = data;
			$scope.updateMedia = angular.copy(data);
			$scope.emprunteurs = $scope.datas.emprunts;
		})
		
		$scope.switchEditView = function(){
			$scope.updateMedia = angular.copy($scope.datas);
			$scope.buttonUpdate = !$scope.buttonUpdate;
		}
		
		$scope.newUpdateMedia = function(){
			$scope.updateMedia.id = $routeParams.id;
			ServiceUrl.updateMedia($scope.updateMedia);
			ServiceUrl.getMediaById($routeParams.id).then(function(data){
				$scope.datas = data;
				$scope.updateMedia = angular.copy(data);
				$scope.emprunteurs = $scope.datas.emprunteurs;
			})
			$scope.buttonUpdate = !$scope.buttonUpdate;
		}
		
		$scope.addingEmprunt = false;
		$scope.emprunt = {};
		$scope.hasError = false;
		
		$scope.setAddingEmprunt =function(){
			$scope.addingEmprunt = !$scope.addingEmprunt;
		}
		
		$scope.isAddingEmprunt = function(){
			return $scope.addingEmprunt;
		}
		
		$scope.addEmprunt = function(){
			ServiceUrl.getAdherentsByParams({nom:$scope.emprunt.nom,prenom:$scope.emprunt.prenom}).then(function(data){
				if(data[0] != undefined){
					ServiceUrl.addEmpruntMedia(data[0].id,$routeParams.id,$scope.emprunt.date);
					$scope.addingEmprunt = false;
					ServiceUrl.getMediaById($routeParams.id).then(function(data){
						$scope.datas = data;
						$scope.emprunteurs = $scope.datas.emprunteurs;
						$scope.hasError = false;
					})
				}else{
					$scope.hasError = true;
				}	
			});
		}
		
		$scope.addSize = function() {
			$scope.sizeArrayMedia += 5;
			if ($scope.sizeArrayMedia >= $scope.datas.length) {
				$scope.sizeMaxMedia = true;
			}
		}
	})
})();