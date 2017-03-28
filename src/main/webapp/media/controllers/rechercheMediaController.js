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

				$scope.resetSort = function(sortValue) {
					if (sortValue != $scope.sortedIdAsc)
						$scope.sortedIdAsc = false;
					if (sortValue != $scope.sortedIdDesc)
						$scope.sortedIdDesc = false;
					if (sortValue != $scope.sortedTitreAsc)
						$scope.sortedTitreAsc = false;
					if (sortValue != $scope.sortedTitreDesc)
						$scope.sortedTitreDesc = false;
					if (sortValue != $scope.sortedAuteurAsc)
						$scope.sortedAuteurAsc = false;
					if (sortValue != $scope.sortedAuteurDesc)
						$scope.sortedAuteurDesc = false;
					if (sortValue != $scope.sortedDisponibiliteAsc)
						$scope.sortedDisponibiliteAsc = false;
					if (sortValue != $scope.sortedDisponibiliteDesc)
						$scope.sortedDisponibiliteDesc = false;
				}

				$scope.resetSort();

				$scope.sortId = function() {
					if ($scope.sortedIdAsc) {
						$scope.resetSort($scope.sortedIdAsc);
						$scope.sortedIdAsc = false;
						$scope.sortedIdDesc = true;
					} else {
						$scope.resetSort($scope.sortedIdDesc);
						$scope.sortedIdDesc = false;
						$scope.sortedIdAsc = true;
					}
				}

				$scope.sortTitre = function() {
					if ($scope.sortedTitreAsc) {
						$scope.resetSort($scope.sortedTitreAsc);
						$scope.sortedTitreAsc = false;
						$scope.sortedTitreDesc = true;
					} else {
						$scope.resetSort($scope.sortedTitreDesc);
						$scope.sortedTitreDesc = false;
						$scope.sortedTitreAsc = true;
					}
				}

				$scope.sortAuteur = function() {
					if ($scope.sortedAuteurAsc) {
						$scope.resetSort($scope.sortedAuteurAsc);
						$scope.sortedAuteurAsc = false;
						$scope.sortedAuteurDesc = true;
					} else {
						$scope.resetSort($scope.sortedAuteurDesc);
						$scope.sortedAuteurDesc = false;
						$scope.sortedAuteurAsc = true;
					}
				}

				$scope.sortDisponibilite = function() {
					if ($scope.sortedDisponibiliteAsc) {
						$scope.resetSort($scope.sortedDisponibiliteAsc);
						$scope.sortedDisponibiliteAsc = false;
						$scope.sortedDisponibiliteDesc = true;
					} else {
						$scope.resetSort($scope.sortedDisponibiliteDesc);
						$scope.sortedDisponibiliteDesc = false;
						$scope.sortedDisponibiliteAsc = true;
					}
				}
				
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