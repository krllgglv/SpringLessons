


angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPathProd = 'http://localhost:8080/app/api/v1/products';
    const contextPathCategory = 'http://localhost:8080/app/api/v1/categories';
    const contextPathCart = 'http://localhost:8080/app/api/v1/cart';
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
            url: contextPathCategory,
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

    $scope.addProductToCart = function (id) {
        $http({
            url: contextPathCart + '/' + id,
            method: 'POST'
        }).then(function (resp) {
            $scope.fillCartTable();
        })
    };

    $scope.fillCartTable = function () {
        $http({
            url: contextPathCart,
            method: 'GET'
        }).then(function (response) {
            $scope.ProductsInCart = response.data;
        });
    }

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
    $scope.fillCartTable();

});