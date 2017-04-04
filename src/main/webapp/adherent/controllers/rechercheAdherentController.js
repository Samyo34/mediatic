(function() {
	'use strict';

	angular.module('mediaticApp.adherent').config(function($routeProvider) {
		$routeProvider.when('/adherents', {
			templateUrl : './adherent/templates/rechercheAdherent.html',
			controller : 'RechercheAdherentCtrl'
		})
	}).controller(
			'RechercheAdherentCtrl',
			function($scope, $routeParams, $rootScope, ServiceUrl) {
				$rootScope.title = "Recherche Adhérents";

				$scope.currentDate = new Date();

				$scope.accurate = false;
				
				$scope.accurateSearch = function(){
					$scope.accurate = !$scope.accurate;
				}
				
				$scope.sizeArrayAd = 10;
				$scope.sizeMaxAd = false;

				$scope.adherents = [];
				ServiceUrl.getAdherents().then(function(adherents) {
					$scope.adherents = adherents;
				});
				
				$scope.sortedTab = [];
				
				$scope.initSort = function() {
					$scope.sortedTab['Id'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Nom'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Prenom'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Mail'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Naissance'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Cotisation'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Possessions'] = {
							'asc' : false,
							'desc' : false
					};
				}
				
				$scope.resetSort = function(id) {
					for (var i in $scope.sortedTab) {
							if($scope.sortedTab[i] == $scope.sortedTab[id])
							{
								$scope.sortedTab[i].asc = !$scope.sortedTab[i].asc;
								$scope.sortedTab[i].desc = !$scope.sortedTab[i].desc;
							}
							else
							{
								$scope.sortedTab[i].asc = false;
								$scope.sortedTab[i].desc = false;
							}
						}
				}
				
				$scope.sort = function(id) {
					var type = $scope.sortedTab[id];
					if(type.asc) {
						$scope.resetSort(id);
						type.asc = false;
						type.desc = true;
					} else {
						$scope.resetSort(id);
						type.asc = true;
						type.desc = false;
					}
				}
				
				$scope.initSort();

				$scope.startSearch = function() {
					var params = {};
					if ($scope.search.id != undefined) {
						params.id = $scope.search.id;
					}
					if ($scope.search.nom != undefined) {
						params.nom = $scope.search.nom;
					}
					if ($scope.search.prenom != undefined) {
						params.prenom = $scope.search.prenom;
					}
					if ($scope.search.mail != undefined) {
						params.mail = $scope.search.mail;
					}
					if ($scope.search.nomOuPrenom != undefined) {
						params.texte = $scope.search.nomOuPrenom;
					}
					ServiceUrl.getAdherentsByParams(params).then(
							function(adherents) {
								$scope.adherents = adherents;
							});
				}

				$scope.addSize = function() {
					$scope.sizeArrayAd += 20;
					if ($scope.sizeArrayAd >= $scope.adherents.length) {
						$scope.sizeMaxAd = true;
					}
				}

			})

})();