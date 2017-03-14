var adherentApp = angular.module('mediaticApp.adherent',[]);
var mediaApp = angular.module('mediaticApp.media',[]);
var navBarApp = angular.module('mediaticApp.navBar',[]);
var mediaticApp = angular.module('mediaticApp', ['ngRoute' , 'mediaticApp.adherent', 'mediaticApp.media', 'mediaticApp.navBar']);


mediaticApp.config(['$routeProvider',
	function($routeProvider) {
	  $routeProvider.otherwise({ redirectTo: '/medias'});
	}
])
.run(['$rootScope', function($rootScope) {
	$rootScope.$on('$routeChangeSuccess', function(event, current) {
        $rootScope.page = current.$$route ? current.$$route.page : 'medias';
    });
}]);