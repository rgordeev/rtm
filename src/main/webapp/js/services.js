'use strict';

/* Services */

var services = angular.module('rtm.services', ['ngResource']);

services.factory('RecordsFactory', function ($resource) {
    return $resource('/rtm/rest/record', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('RecordFactory', function ($resource) {
    return $resource('/rtm/rest/record/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});