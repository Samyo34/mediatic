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
		
		$scope.medias = [];
		ServiceUrl.getMedias().then(function(medias){
			$scope.medias = medias;
		});
		
		
		
	})
	
})();