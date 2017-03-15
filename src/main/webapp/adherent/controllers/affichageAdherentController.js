(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent')
	.config(function($routeProvider){
		$routeProvider.when('/adherent/:id',{
			templateUrl:'/adherent/templates/affichageAdherent.html',
			controller:'AffichageAdherentCtrl'
		})
	})
	.controller('AffichageAdherentCtrl',function($scope,$routeParams,$rootScope,ServiceUrl){
		$rootScope.titre = 'Affichage Adherent';
		
		$scope.datas = [] ;
		$scope.updateAdherent ={};
		ServiceUrl.getAdherentById($routeParams.id).then(function(data){
			console.log(data);
			$scope.datas = data;
			$scope.medias = $scope.datas.emprunt;
		});	
		$scope.buttonUpdate = false;
		
		$scope.newUpdateAdherent = function(){
			$scope.updateAdherent.id = $routeParams.id;
			ServiceUrl.updateAdherent($scope.updateAdherent);
			console.log($scope.updateAdherent);
			ServiceUrl.getAdherentById($routeParams.id).then(function(data){
				console.log(data);
				$scope.datas = data;
				$scope.emprunteurs = $scope.datas.emprunteurs;
			})
			$scope.buttonUpdate = !$scope.buttonUpdate;
		}
		
	})
	
})();