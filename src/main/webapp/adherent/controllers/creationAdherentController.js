(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent')
	.config(function($routeProvider){
		$routeProvider.when('/adherent',{
			templateUrl:'./adherent/templates/creationAdherent.html',
			controller:'creationAdherentCtrl'
		})
	})

	
	.controller('creationAdherentCtrl',function($scope,$routeParams,$rootScope, ServiceUrl, $location){	
		
		$rootScope.title = 'Création Adhérent';
		$rootScope.activeLink('adherent');
		
		$scope.user = {};
//		$scope.userBeta = {
//				lastName:"de garam",
//				firstName: 
//				
//		};
		$scope.user.cotisation = {}
		
		$scope.createUser= function(){
			console.log($scope.user);
			if (($scope.user.nom == undefined) ||($scope.user.prenom == undefined) || ($scope.user.adresse == undefined)){

				console.log("Erreur: tous les champs doivent être remplis");
			}
			else{
				ServiceUrl.addAdherent($scope.user).then(function(data){
					var id =data.data.id;
					var url = "/adherent/"+id;
					$location.path(url);
				})
				}
		}
	});
	
})();