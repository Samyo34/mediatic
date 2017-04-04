(function() {
	'use strict';

	angular.module('mediaticApp.navBar').controller('navBarCtrl',
			function($scope, $routeParams, $rootScope) {

				$scope.resetActivesLinks = function() {
					$scope.isMedia = false;
					$scope.isMedias = false;
					$scope.isAdherent = false;
					$scope.isAdherents = false;
				}

				$rootScope.activeLink = function(page) {
					$scope.resetActivesLinks();
					switch (page) {
					case "adherent":
						$scope.isAdherent = true;
						break;
					case "adherents":
						$scope.isAdherents = true;
						break;
					case "media":
						$scope.isMedia = true;
						break;
					case "medias":
						$scope.isMedias = true;
					}
				}

			})

})();