(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent')
	.config(function($routeProvider){
		$routeProvider.when('/adherent/:id',{
			templateUrl:'./adherent/templates/affichageAdherent.html',
			controller:'AffichageAdherentCtrl'
		})
	})
	.controller('AffichageAdherentCtrl',function($scope,$routeParams,$rootScope,ServiceUrl){
		$rootScope.titre = 'Affichage Adherent';
		
		$scope.datas = [] ;
		$scope.updateAdherent ={};
		$scope.adresse={};
		$scope.buttonUpdate = false;
		
		ServiceUrl.getAdherentById($routeParams.id).then(function(data){
			$scope.datas = data;
			$scope.updateMedia = angular.copy(data);
			$scope.medias = $scope.datas.emprunt;
		});	
		
		$scope.switchEditView = function(){
			$scope.updateMedia = angular.copy($scope.datas);
			$scope.buttonUpdate = !$scope.buttonUpdate;
		}
		
		$scope.newUpdateAdherent = function(){
			$scope.updateAdherent.id = $routeParams.id;
			$scope.updateAdherent.adresse =$scope.adresse;
			ServiceUrl.updateAdherent($scope.updateAdherent);
			ServiceUrl.getAdherentById($routeParams.id).then(function(data){
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
			ServiceUrl.getMediasByParams({titre:$scope.emprunt.titre,auteur:$scope.emprunt.auteur}).then(function(data){
				if(data[0] != undefined){
					ServiceUrl.addEmpruntMedia(data[0].id,$routeParams.id,$scope.emprunt.date);
					$scope.addingEmprunt = false;
					ServiceUrl.getAdherentById($routeParams.id).then(function(data){
						$scope.datas = data;
						$scope.medias = $scope.datas.emprunt;
						$scope.hasError = false;
				});
				}else{
					$scope.hasError = true;
				}	
			});
		};		
	});
})();