(function(){
	'use strict';
	
	angular.module('mediaticApp.navBar')
	.controller('navBarCtrl',function($scope,$routeParams,$rootScope){
		
		$scope.resetActivesLinks = function() {
			$scope.isMedia = false;
			$scope.isMedias = false;
			$scope.isAdherent = false;
			$scope.isAdherents = false;
		}
		
		$scope.resetActivesLinks();
		
		console.log($rootScope.page);
		
		switch ($rootScope.page) {
	    case "adherent":
	    	$scope.isAdherent = true;
	        break;
	    case "adherents":
	    	$scope.isAdherents = true;
	        break;
	    case "media":
	    	$scope.isMedia = true;
	        break;
	    default:
	    	$scope.isMedias = true;
	        break;
	}
	})
	
})();