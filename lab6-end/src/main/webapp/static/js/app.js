wafepaApp = angular.module('wafepaApp', ['wafepaApp.controllers','wafepaApp.directives', 'wafepaApp.routes','wafepaApp.services',
                                          'ui.bootstrap']);



// ---------------------FILTER UNIQUE ----------------------------
  wafepaApp.filter('unique', function() { return function(collection, keyname) {
  var output = [], keys = [];
  
  angular.forEach(collection, function(item) { var key = item[keyname];
  if(keys.indexOf(key) === -1) { keys.push(key); output.push(item); } });
  
  return output; }; });





