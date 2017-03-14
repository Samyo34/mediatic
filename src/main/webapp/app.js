var adherentApp = angular.module('mediaticApp.adherent',[]);
var mediaApp = angular.module('mediaticApp.media',[]);
var mediaticApp = angular.module('mediaticApp', ['ngRoute' , 'mediaticApp.adherent','mediaticApp.media']);


mediaticApp.config(['$routeProvider',
	function($routeProvider) {
	  $routeProvider.otherwise({ redirectTo: '/medias'});
	}
]);