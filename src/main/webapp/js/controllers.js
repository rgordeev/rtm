'use strict';

/* Controllers */


var app = angular.module('rtm.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});

app.controller('RecordListCtrl', ['$scope', 'RecordsFactory', 'RecordFactory', '$location',
    function ($scope, RecordsFactory, RecordFactory, $location) {

        // callback for ng-click 'editRecord':
        $scope.editRecord = function (id) {
            $location.path('/record-detail/' + id);
        };

        // callback for ng-click 'deleteRecord':
        $scope.deleteRecord = function (id) {
            RecordFactory.delete({ id: id });
            $scope.records = RecordsFactory.query();
        };

        // callback for ng-click 'createRecord':
        $scope.createNewRecord = function () {
            $location.path('/record-creation');
        };

        $scope.records = RecordsFactory.query();
    }]);

app.controller('RecordDetailCtrl', ['$scope', '$routeParams', 'RecordFactory', '$location',
    function ($scope, $routeParams, RecordFactory, $location) {

        // callback for ng-click 'updateRecord':
        $scope.updateRecord = function () {
            RecordFactory.update($scope.record);
            $location.path('/record-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/record-list');
        };

        $scope.record = RecordFactory.show({id: $routeParams.id});
    }]);

app.controller('RecordCreationCtrl', ['$scope', 'RecordsFactory', '$location',
    function ($scope, RecordsFactory, $location) {

        // callback for ng-click 'createNewRecord':
        $scope.createNewRecord = function () {
            RecordsFactory.create($scope.record);
            $location.path('/record-list');
        }
    }]);


