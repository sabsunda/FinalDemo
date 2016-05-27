
(function(){
	
	var app = angular.module('MyBlog',['ngRoute','akoenig.deckgrid']);
	
	/*app.config(['$routeProvider', 
	    function($routeProvider){
			$routeProvider.
				when('/signup',{
					templateUrl:'signup.html',
					controller:'SignupController'
				}).
				otherwise({
					redirectTo:'#'
				});
		}
	]);*/

	
	
	app.controller('TopWrapperController',function($http, $log, $scope, $window){
		var controller = this;
		$scope.categories=[{name:"Society", info:"Culture, Social Openion ...", urlPath: "assets/img/society.jpg"},
							{name:"Technology", info:"Networking, Cloud Computing, Internet of Things...",urlPath: "assets/img/technology.jpg"},
							{name:"Politics", info:"Issues, Analysis...",urlPath: "assets/img/ernesto_che_guevara_by_last_hope94.jpg"},
							{name:"Entertainment", info:"Cinemas, Sports ...",urlPath: "assets/img/entertainment.jpg"}];
		
		
		$scope.photos = [
			{id: 'p1', 'title': 'A nice day!', src: "http://lorempixel.com/300/400/"},
			{id: 'p2', 'title': 'Puh!', src: "http://lorempixel.com/300/400/sports"},
			{id: 'p3', 'title': 'What a club!', src: "http://lorempixel.com/300/400/nightlife"},
			{id: 'p4', 'title': 'What a club!', src: "assets/img/ernesto_che_guevara_by_last_hope94.jpg"},
			{id: 'p4', 'title': 'What a club!', src: "assets/img/society.jpg"},
			{id: 'p6', 'title': 'What a club!', src: "assets/img/technology.jpg"},
			{id: 'p7', 'title': 'What a club!', src: "assets/img/entertainment.jpg"}
		];
		
		$("#myCarousel").bind('slid.bs.carousel', function (e) {
			console.log( $('#myCarousel .active').index());
			var urlpath = $scope.categories[$('#myCarousel .active').index()].urlPath;
			$(".top-wrapper-background").backstretch(urlpath);
			$(".top-wrapper-background").backstretch("resize");
		});
		
		$("#myCarousel").bind('slid.bs.carousel', function (e) {
			console.log( $('#myCarousel .active').index());
			var urlpath = $scope.categories[$('#myCarousel .active').index()].urlPath;
			$(".top-wrapper-background").backstretch(urlpath);
			$(".top-wrapper-background").backstretch("resize");
		});
	});
	
	app.controller('SignupController',function($http, $log, $scope, $window){

	});
	
})();

