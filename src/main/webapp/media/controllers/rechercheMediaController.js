(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/medias',{
			templateUrl:'/media/templates/rechercheMedia.html',
			controller:'RechercheMediaCtrl'
		})
	})
	.controller('RechercheMediaCtrl',function($scope,$routeParams,$rootScope, ServiceUrl){
		$rootScope.title = "Recherche Média";
		
		$scope.datas = [] ;
		ServiceUrl.getMediaRecherche().then(function(data){
			console.log(data);
			$scope.datas = data;
		});
		
		
		
	})
	
})();