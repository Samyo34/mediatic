(function() {
	'use strict';

	angular.module('mediaticApp.media').config(function($routeProvider) {
		$routeProvider.when('/medias', {
			templateUrl : './media/templates/rechercheMedia.html',
			controller : 'RechercheMediaCtrl'
		})
	}).controller('RechercheMediaCtrl',
			function($scope, $routeParams, $rootScope, ServiceUrl) {
				$rootScope.title = "Recherche Médias";

				$scope.sizeArrayMedia = 10;
				$scope.sizeMaxMedia = false;

				$scope.medias = [];
				ServiceUrl.getMedias().then(function(medias) {
					$scope.medias = medias;
				});

				$scope.sortedTab = [];
				
				$scope.initSort = function() {
					$scope.sortedTab['Id'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Titre'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Auteur'] = {
							'asc' : false,
							'desc' : false
					};
					$scope.sortedTab['Disponibilite'] = {
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
					if ($scope.search.titre != undefined) {
						params.titre = $scope.search.titre;
					}
					if ($scope.search.auteur != undefined) {
						params.auteur = $scope.search.auteur;
					}
					if ($scope.search.type != undefined) {
						params.type = $scope.search.type;
					}
					ServiceUrl.getMediasByParams(params).then(function(medias) {
						$scope.medias = medias;
					});
				}

				$scope.addSize = function() {
					$scope.sizeArrayMedia += 5;
					if ($scope.sizeArrayMedia >= $scope.medias.length) {
						$scope.sizeMaxMedia = true;
					}
				}

			})

})();