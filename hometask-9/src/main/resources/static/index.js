


angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPathProd = 'http://localhost:8080/app/api/v1/products';
    const contextPathCat = 'http://localhost:8080/app/api/v1/categories';
    $scope.page = 1;

    $scope.saveProduct = function () {
        $http.post(contextPathProd, $scope.NewProduct)
            .then(function (resp) {
                $scope.NewProduct = null
                $scope.fillTable();
            })
    };

    $scope.getCategories = function () {
        $http({
            url: contextPathCat,
            method: 'GET'
        }).then(function (response) {
            $scope.Categories = response.data;
        })
    };

    $scope.deleteProductById = function (id) {
        $http({
            url: contextPathProd + '/' + id,
            method: 'DELETE'
        }).then(function (resp) {
            $scope.fillTable();
        })
    };

    $scope.fillTable = function (page) {
            $http({
                url: contextPathProd,
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
    $scope.getCategories();
});