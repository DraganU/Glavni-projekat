carWashApp = angular.module('carWashApp.directives', []);

carWashApp.directive('washesTable', function() {
    return {
        restrict: 'E',                          // moguće vrednosti: 'A' (attribute), 'E' (element), 'C' (class), 'M' (comment)
        //template: '<span>My span</span>',       // HTML koji će biti renderovan (koristi se ovo ILI templateUrl, ne oba)
        templateUrl: 'static/html/washesTable.html',    // putanja ka fajlu koji sadrži HTML (koristi se ovo ILI template, ne oba)
        controller: 'WashController'              // kontroler
    }
});