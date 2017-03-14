(function(){
	'use strict';
	
	angular.module('mediaticApp.media')
	.config(function($routeProvider){
		$routeProvider.when('/media',{
			templateUrl:'/media/templates/creationMedia.html',
			controller:'creationMediaCtrl'
		})
	})

	
	.controller('creationMediaCtrl',function($scope,$routeParams,$rootScope){	
		
		$rootScope.title = 'MEDIAS';
		
	})
	
})();