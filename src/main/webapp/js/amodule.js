(function() {
    var app = angular.module('gemStore', []);
    var gem = {name: 'Product name', price: 200};
    app.controller('MyController', function () {
        this.product = gem;
    });
})();