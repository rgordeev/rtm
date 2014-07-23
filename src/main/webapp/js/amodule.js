(function() {
    var app = angular.module('gemStore', []);

    var gem = {
        name: 'The Good',
        price: 110.50,
        canPurchase: false,
        soldOut: false
    };

    app.controller('MyController', function () {
        this.product = gem;
    });
})();