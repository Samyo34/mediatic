(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent')
	.config(function($routeProvider){
		$routeProvider.when('/adherent',{
			templateUrl:'/adherent/templates/creationAdherent.html',
			controller:'creationAdherentCtrl'
		})
	})

	
	.controller('creationAdherentCtrl',function($scope,$routeParams,$rootScope){	
		
		$rootScope.title = 'MEDIAS';
		
	})
	
})();