(function(){
	'use strict';
	
	angular.module('mediaticApp.adherent')
	.config(function($routeProvider){
		$routeProvider.when('/adherent/:id',{
			templateUrl:'/adherent/templates/affichageAdherent.html',
			controller:'AffichageAdherentCtrl'
		})
	})
	.controller('AffichageAdherentCtrl',function($scope,$routeParams,$rootScope){
		$rootScope.titre = 'Affichage Adherent';
		
		$scope.datas = [] ;
		ServiceUrl.getAdherentById($routeParams.id).then(function(data){
			console.log(data);
			$scope.datas = data;
			//$scope.emprunteurs = $scope.datas.emprunteurs;
		});	
	})
	
})();