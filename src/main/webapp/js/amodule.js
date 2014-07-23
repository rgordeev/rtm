(function() {
    var app = angular.module('gemStore', []);

    var gem = {
        name: 'The Good',
        price: 110.50,
        canPurchase: true,
        soldOut: false
    };

    app.controller('MyController', function () {
        this.product = gem;
    });
})();