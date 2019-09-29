if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

function println(text){
    console.log(text)
}

var app = angular.module('Xapp', []);
app.factory('socket', function() {
    var service = {};
    service.connect = function(page) {

        if(service.ws) { return; }
        var ws = new ReconnectingWebSocket("wss://"+location.host+"/websocket");
        ws.onopen = function() {
            if(page == "exchange") {
                service.send('markets');
                service.send('buyOrdersBTCETH');
                service.send('sellOrdersBTCETH');
                service.send('recentTradesBTCETH');
                service.send('openBuyOrdersBTCETH');
                service.send('openSellOrdersBTCETH');
                service.send('closedBuyOrdersBTCETH');
                service.send('closedSellOrdersBTCETH');
                //  service.send(JSON.stringify({"method":"bitrates"}));
            }
            if(page == "wallet") {
                service.send('currencies');
            }

            console.log("Connection opened");

        };
        ws.onerror = function() {
            service.callback("Failed to open a connection");
            console.log("Failed to open a connection");
        }

        ws.onclose = function() {
            service.callback(JSON.stringify([{"msg":"Connection closed"}]));
            console.log("Connection closed");
        }
        ws.onmessage = function(message) {service.callback(message.data);};
        service.ws = ws;}

    service.send = function(message) {service.ws.send(message);}
    service.subscribe = function(callback) {service.callback = callback;}
    service.close = function() {service.ws.close();}

    return service;
});
app.controller('exchCtrl', ['$rootScope', '$scope', '$http', '$window', 'socket', '$log',
    function($rootScope, $scope, $http, $window, socket, $log) {
        $scope.orderRate = 0
        $scope.volume = 0
    $scope.markets = []
        $scope.buyOrders = []
        $scope.sellOrders = []
        $scope.recentTrades = []
        $scope.openBuyOrders = []
        $scope.openSellOrders = []

    socket.connect("exchange")
    socket.subscribe(function(message, $rootScope) {
        console.log(JSON.parse(message).method)
        var response = JSON.parse(message)
        switch (response.method) {
            case "markets":
                $scope.$apply(function () {
                    $scope.markets = []
                    $scope.markets = response.message
                    console.log($scope.markets)
                    $scope.selectedMarket = $scope.markets[0];
                })
                break;
            case "buyOrders":
                $scope.$apply(function () {
                    $scope.buyOrders = []
                    $scope.buyOrders = response.message
                    console.log($scope.buyOrders)
                })
                break;
            case "sellOrders":
                $scope.$apply(function () {
                    $scope.sellOrders = []
                    $scope.sellOrders = response.message
                    console.log($scope.sellOrders)
                })
                break;
            case "recentTrades":
                $scope.$apply(function () {
                    $scope.recentTrades = []
                    $scope.recentTrades = response.message
                    console.log($scope.recentTrades)
                })
                break;
            case "openBuyOrders":
                $scope.$apply(function () {
                    $scope.openBuyOrders = []
                    $scope.openBuyOrders = response.message
                    console.log($scope.openBuyOrders)
                })
                break;
            case "openSellOrders":
                $scope.$apply(function () {
                    $scope.openSellOrders = []
                    $scope.openSellOrders = response.message
                    console.log($scope.openSellOrders)
                })
                break;
            case "closedBuyOrders":
                $scope.$apply(function () {
                    $scope.closedBuyOrders = []
                    $scope.closedBuyOrders = response.message
                    console.log($scope.closedBuyOrders)
                })
                break;
            case "closedSellOrders":
                $scope.$apply(function () {
                    $scope.closedSellOrders = []
                    $scope.closedSellOrders = response.message
                    console.log($scope.closedSellOrders)
                })
                break;
        }
        })

    $scope.selectedMarket = $scope.markets[0];

    $scope.changeMarket = function(){
        setTimeout($scope.refreshData, 0);
    }

    $scope.refreshData = function(){
        socket.send('buyOrders'+$scope.selectedMarket.market);
        socket.send('sellOrders'+$scope.selectedMarket.market);
        socket.send('recentTrades'+$scope.selectedMarket.market);
        socket.send('openBuyOrders'+$scope.selectedMarket.market);
        socket.send('openSellOrders'+$scope.selectedMarket.market);
        socket.send('closedBuyOrders'+$scope.selectedMarket.market);
        socket.send('closedSellOrders'+$scope.selectedMarket.market);
    }

    $scope.selectOrderType = function(ordType){
        if(ordType == "Buy"){
            return $scope.selectedMarket.buy
        } else {
            return $scope.selectedMarket.sell
        }
    }

    $scope.setOrderRate = function(rate){
        $scope.orderRate = rate
    }

    $scope.doTrade = function(rate, vol, orderType){
        var httpRequest = $http({
            method: 'POST',
            url: '/doTrade',
            data: {rate: rate, vol: vol, market: $scope.selectedMarket.market, orderType: orderType.toLowerCase()},
            headers: {'Content-Type': 'application/json'}

        }).then(function (data) {
            if(data.data.success){
               // $scope.refreshData()
                console.log(data)
            } else {
                console.log(data)
            }

        })
    }

        $scope.deleteOrder = function(orderId, orderType){
            var httpRequest = $http({
                method: 'POST',
                url: '/deleteOrder',
                data: {orderId: orderId, orderType: orderType.toLowerCase()},
                headers: {'Content-Type': 'application/json'}

            }).then(function (data) {
                if(data.data.success){
                 //   $scope.refreshData()
                    console.log(data)
                } else {
                    console.log(data)
                }

            })
        }

}]);
app.controller('loginCtrl', ['$scope', '$http', '$window', function($scope, $http, $window) {
  $scope.loginPage = true
    $scope.email = "benson.samuel@gmail.com"
  //  $scope.password

    $scope.doLogin = function(email, password){
        var httpRequest = $http({
            method: 'POST',
            url: '/doLogin',
            data: {email: email, password: password},
            headers: {'Content-Type': 'application/json'}

        }).then(function (data) {
            if(data.data.success){
                $scope.contentLogin = "Login Success!"
                $window.location.href = '/logged-in/exchange';
            } else {
                $scope.contentLogin = "Login Failed!"
            }

        })

    }
}]);
app.controller('signupCtrl', ['$scope', '$http', function($scope, $http) {
    $scope.signupPage = true
    $scope.email = "benson.samuel@gmail.com"
    //  $scope.password

    $scope.doSignup = function(email, password){
            var httpRequest = $http({
                method: 'POST',
                url: '/doSignup',
                data: {email: email, password: password},
                headers: {'Content-Type': 'application/json'}

            }).then(function (data) {
                $scope.contentSignup = data.data.message
            })

    }
}]);

app.controller('walletCtrl', ['$scope', '$http', 'socket', function($scope, $http, socket) {

    $scope.currencies = []

    socket.connect("wallet")
    socket.subscribe(function(message, $rootScope) {
        console.log("socket Response ==> " + JSON.parse(message).method)
        var response = JSON.parse(message)
        switch (response.method) {
            case "currencies":
                $scope.$apply(function () {
                    $scope.currencies = []
                    $scope.currencies = response.message
                    console.log($scope.currencies)
                    $scope.selectedCurrency = $scope.currencies[0];
                })
                break;
            case "markets":
                $scope.$apply(function () {
                    $scope.markets = []
                    $scope.markets = response.message
                    console.log($scope.markets)
                    $scope.selectedMarket = $scope.markets[0];
                })
                break;
        }
    })

    $scope.selectedCurrency = $scope.currencies[0];

    $scope.testGet = function(){
        $http.get("/test")
            .then(function(response) {
                println(response)
            });
    }

}]);