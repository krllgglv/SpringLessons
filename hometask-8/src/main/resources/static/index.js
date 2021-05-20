

angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1/products';
    $scope.page = 1;

    $scope.saveProduct = function () {
        console.log($scope.NewPatient)
        $http.post(contextPath, $scope.NewProduct)
            .then(function (resp) {
                $scope.Product = null
                $scope.fillTable();
            })

    };
    $scope.deleteProductById = function (id) {
        $http({
            url: contextPath + '/' + id,
            method: 'DELETE'
        }).then(function (resp) {
            $scope.fillTable();
        })
    };
    $scope.fillTable = function (page) {

            $http({
                url: contextPath,
                method: 'GET',
                params: {
                    name: $scope.filter ? $scope.filter.name : null,
                    lowLimit: $scope.filter ? $scope.filter.min_price : null,
                    upLimit: $scope.filter ? $scope.filter.max_price : null,
                    page: page <= 1 ? 1 : page > ($scope.Products.totalPages) ? ($scope.Products.totalPages) : page
                }
            }).then(function (response) {
                $scope.Products = response.data;
            });

    };


    $scope.fillTable($scope.page);
});