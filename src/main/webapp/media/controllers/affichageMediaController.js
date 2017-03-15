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
			console.log(data);
			$scope.datas = data;
			$scope.emprunteurs = $scope.datas.emprunteurs;
		})
		$scope.buttonUpdate = false;
		
		
		
		$scope.newUpdateMedia = function(){
			$scope.updateMedia.id = $routeParams.id;
			ServiceUrl.updateMedia($scope.updateMedia);
			console.log($scope.updateMedia);
			ServiceUrl.getMediaById($routeParams.id).then(function(data){
				console.log(data);
				$scope.datas = data;
				$scope.emprunteurs = $scope.datas.emprunteurs;
			})
			$scope.buttonUpdate = !$scope.buttonUpdate;
		}
		
		
	})
	
	
})();