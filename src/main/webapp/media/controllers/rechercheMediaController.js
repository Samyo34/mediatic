(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/medias',{
			templateUrl:'/media/templates/rechercheMedia.html',
			controller:'RechercheMediaCtrl'
		})
	})
	.controller('RechercheMediaCtrl',function($scope,$routeParams,$rootScope){
		$rootScope.title = "Recherche Média";
	})
	
})();