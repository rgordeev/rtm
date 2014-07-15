'use strict';

angular.module('rtm', ['rtm.filters', 'rtm.services', 'rtm.directives', 'rtm.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/record-list', {templateUrl: 'partials/record-list.html', controller: 'RecordListCtrl'});
        $routeProvider.when('/record-detail/:id', {templateUrl: 'partials/record-detail.html', controller: 'RecordDetailCtrl'});
        $routeProvider.when('/record-creation', {templateUrl: 'partials/record-creation.html', controller: 'RecordCreationCtrl'});
        $routeProvider.otherwise({redirectTo: '/record-list'});
    }]);
