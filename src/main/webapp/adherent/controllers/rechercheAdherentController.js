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
				
				$scope.resetSort = function(sortValue) {
					if (sortValue != $scope.sortedIdAsc)
						$scope.sortedIdAsc = false;
					if (sortValue != $scope.sortedIdDesc)
						$scope.sortedIdDesc = false;
					if (sortValue != $scope.sortedPrenomAsc)
						$scope.sortedPrenomAsc = false;
					if (sortValue != $scope.sortedPrenomDesc)
						$scope.sortedPrenomDesc = false;
					if (sortValue != $scope.sortedNomAsc)
						$scope.sortedNomAsc = false;
					if (sortValue != $scope.sortedNomDesc)
						$scope.sortedNomDesc = false;
					if (sortValue != $scope.sortedMailAsc)
						$scope.sortedMailAsc = false;
					if (sortValue != $scope.sortedMailDesc)
						$scope.sortedMailDesc = false;
					if (sortValue != $scope.sortedNaissanceAsc)
						$scope.sortedNaissanceAsc = false;
					if (sortValue != $scope.sortedNaissanceDesc)
						$scope.sortedNaissanceDesc = false;
					if (sortValue != $scope.sortedCotisationAsc)
						$scope.sortedCotisationAsc = false;
					if (sortValue != $scope.sortedCotisationDesc)
						$scope.sortedCotisationDesc = false;
					if (sortValue != $scope.sortedPossessionsAsc)
						$scope.sortedPossessionsAsc = false;
					if (sortValue != $scope.sortedPossessionsDesc)
						$scope.sortedPossessionsDesc = false;
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

				$scope.sortPrenom = function() {
					if ($scope.sortedPrenomAsc) {
						$scope.resetSort($scope.sortedPrenomAsc);
						$scope.sortedPrenomAsc = false;
						$scope.sortedPrenomDesc = true;
					} else {
						$scope.resetSort($scope.sortedPrenomDesc);
						$scope.sortedPrenomDesc = false;
						$scope.sortedPrenomAsc = true;
					}
				}

				$scope.sortNom = function() {
					if ($scope.sortedNomAsc) {
						$scope.resetSort($scope.sortedNomAsc);
						$scope.sortedNomAsc = false;
						$scope.sortedNomDesc = true;
					} else {
						$scope.resetSort($scope.sortedNomDesc);
						$scope.sortedNomDesc = false;
						$scope.sortedNomAsc = true;
					}
				}

				$scope.sortMail = function() {
					if ($scope.sortedMailAsc) {
						$scope.resetSort($scope.sortedMailAsc);
						$scope.sortedMailAsc = false;
						$scope.sortedMailDesc = true;
					} else {
						$scope.resetSort($scope.sortedMailDesc);
						$scope.sortedMailDesc = false;
						$scope.sortedMailAsc = true;
					}
				}

				$scope.sortNaissance = function() {
					if ($scope.sortedNaissanceAsc) {
						$scope.resetSort($scope.sortedNaissanceAsc);
						$scope.sortedNaissanceAsc = false;
						$scope.sortedNaissanceDesc = true;
					} else {
						$scope.resetSort($scope.sortedNaissanceDesc);
						$scope.sortedNaissanceDesc = false;
						$scope.sortedNaissanceAsc = true;
					}
				}
				
				$scope.sortCotisation = function() {
					if ($scope.sortedCotisationAsc) {
						$scope.resetSort($scope.sortedCotisationAsc);
						$scope.sortedCotisationAsc = false;
						$scope.sortedCotisationDesc = true;
					} else {
						$scope.resetSort($scope.sortedCotisationDesc);
						$scope.sortedCotisationDesc = false;
						$scope.sortedCotisationAsc = true;
					}
				}
				
				$scope.sortPossessions = function() {
					if ($scope.sortedPossessionsAsc) {
						$scope.resetSort($scope.sortedPossessionsAsc);
						$scope.sortedPossessionsAsc = false;
						$scope.sortedPossessionsDesc = true;
					} else {
						$scope.resetSort($scope.sortedPossessionsDesc);
						$scope.sortedPossessionsDesc = false;
						$scope.sortedPossessionsAsc = true;
					}
				}

				$scope.sizeArrayAd = 10;
				$scope.sizeMaxAd = false;

				$scope.adherents = [];
				ServiceUrl.getAdherents().then(function(adherents) {
					console.log(adherents);
					$scope.adherents = adherents;
					
					
				});

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