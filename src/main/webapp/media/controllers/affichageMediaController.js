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
		ServiceUrl.getMediaById($routeParams.id).then(function(data){
			console.log(data);
			$scope.datas = data;
			$scope.emprunteurs = $scope.datas.emprunteurs;
		});	
	})
	
	
})();