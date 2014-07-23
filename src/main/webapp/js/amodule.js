(function() {
    var app = angular.module('gemStore', []);

    var gems = [
        { name: 'Azurite', price: 2.95 },
        { name: 'Bloodstone', price: 5.95 },
        { name: 'Zircon', price: 3.95 },
    ];

    app.controller('MyController', function () {
        this.products = gems;
    });
})();