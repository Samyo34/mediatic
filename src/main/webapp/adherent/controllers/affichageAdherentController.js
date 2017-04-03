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
		
		$scope.sortedTab = [];
		
		$scope.initSort = function() {
			$scope.sortedTab['Id'] = {
					'asc' : false,
					'desc' : false
			};
			$scope.sortedTab['Titre'] = {
					'asc' : false,
					'desc' : false
			};
			$scope.sortedTab['Auteur'] = {
					'asc' : false,
					'desc' : false
			};
			$scope.sortedTab['Date emprunt'] = {
					'asc' : false,
					'desc' : false
			};
			$scope.sortedTab['Date retour'] = {
					'asc' : false,
					'desc' : false
			};
		}
		
		$scope.resetSort = function(id) {
			for (var i in $scope.sortedTab) {
					if($scope.sortedTab[i] == $scope.sortedTab[id])
					{
						$scope.sortedTab[i].asc = !$scope.sortedTab[i].asc;
						$scope.sortedTab[i].desc = !$scope.sortedTab[i].desc;
					}
					else
					{
						$scope.sortedTab[i].asc = false;
						$scope.sortedTab[i].desc = false;
					}
				}
		}
		
		$scope.sort = function(id) {
			var type = $scope.sortedTab[id];
			if(type.asc) {
				$scope.resetSort(id);
				type.asc = false;
				type.desc = true;
			} else {
				$scope.resetSort(id);
				type.asc = true;
				type.desc = false;
			}
		}

		$scope.initSort();
		
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