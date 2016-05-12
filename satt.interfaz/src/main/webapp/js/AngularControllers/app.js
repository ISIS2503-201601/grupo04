/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(){var aplicacionMundial= angular.module('aplicacionMundial',[]);

    aplicacionMundial.directive('toolbar', function(){
        
        return{
            restrict:'E',
            templateUrl: 'partials/toolbar.html',
            controller:function(){
                this.tab=0;
                this.selectTab=function(setTab){
                    this.tab=setTab;
                };
                this.isSelected=function(tabParam){
                    return this.tab===tabParam;
                };
            },
            controllerAs:'toolbar'
        };
    });

    aplicacionMundial.directive('re', function(){

        return{
            restrict:'E',
            templateUrl:'partials/registrosSensores.html',
            controller: 'getRegSensores'
        };
    });
 
    aplicacionMundial.controller("getRegSensores", function($http, $scope) {

    $http.get('http://localhost:8080/satt.servicios/webresources/Registro/registros').
      success(function(data, status, headers, config) {
        $scope.competitors = data;
      }).
      error(function(data, status, headers, config) {
        // log error
      });
    });

    aplicacionMundial.directive('se', function(){
        
        return{
            restrict:'E',
            templateUrl:'partials/sensores.html',
            controller: 'darSensores'
        };
    });
 
    aplicacionMundial.controller("darSensores", function($http, $scope) {
        $http.get('http://localhost:8080/satt.servicios/webresources/Sensor/sensores').
        success(function(data, status, headers, config) {
        $scope.competitors = data;
        }).
        error(function(data, status, headers, config) {
          // log error
        });
    });
    
    aplicacionMundial.directive('si', function(){
        return{
            restrict:'E',
            templateUrl:'partials/crearRegistroSismico.html',
            controller: 'crearRegSismico'
        };
    });
 
    aplicacionMundial.controller("crearRegSismico", function($http, $scope) {
 
        $scope.addRegSismico=function(){
            console.log('name');
            $http.post('http://localhost:8080/satt.servicios/webresources/Registro/reportarSismo', JSON.stringify($scope.competitor)).success(function(data,headers){
                $scope.competitor={};
                $scope.toolbar.selectTab(1);
            });
        };
    });
})();