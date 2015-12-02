app.controller('homePageCtrl', function($scope, $http) {
  $http.get("http://localhost:8080/greeting")
  .success(function (response) {$scope.names = response._links.Next.href;
                                console.log($scope.names);});
});