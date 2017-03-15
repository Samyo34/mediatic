(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/media',{
			templateUrl:'/media/templates/creationMedia.html',
			controller:'creationMediaCtrl'
		})
	})

	
	.controller('creationMediaCtrl',function($scope,$routeParams,$rootScope, ServiceUrl){	
		
		$rootScope.title = 'MEDIAS';

		$scope.media = {};
		$scope.createMedia = function(){
			if (($scope.media.titre == undefined) ||($scope.media.auteur == undefined) || ($scope.media.type == undefined)){
				console.log("Erreur: tous les champs doivent être remplis");
			}
			else{
			ServiceUrl.addMedia($scope.media);
			$scope.media = {};
			}
		}
		
	}) 
	
})();