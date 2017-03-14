(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/media/:id',{
			templateUrl:'/media/templates/affichageMedia.html',
			controller:'affichageMediaCtrl'
		})
	})
	.controller('affichageMediaCtrl',function($scope,$routeParams,$rootScope){
		$rootScope.titre = 'Affichage Media';
	})
	
})();