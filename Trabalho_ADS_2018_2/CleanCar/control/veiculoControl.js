var app = angular.module('veiculoModule',[]);
var url = 'http://localhost:8080/CleanCarServer/rs/veiculo';

app.controller('veiculoControl',function($scope, $http){
	

	$scope.pesquisar = function(){
		$http.get(url).success(function (veiculosRetorno) {
			$scope.veiculos = veiculosRetorno;
		}).error(function (menssagemErro) {
			alert(menssagemErro);
		});
	}
	
	$scope.novo = function () {
        $scope.veiculo = {};
        $scope.veiculo.id = '';
        $scope.mensagens = [];
    }

    $scope.montaMensagemErro = function (listaErro) {
        $scope.mensagens = [];
        $scope.mensagens.push('Falha de validação retornada do servidor');
        angular.forEach(listaErro, function (value, key) {
            $scope.mensagens.push(value.message);
        });
    }
	
	$scope.salvar = function () {
        if ($scope.veiculo.id == null) {
            $http.post(url, $scope.veiculo).success(function (veiculo) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('veiculo salvo com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        } else {
            $http.put(url, $scope.veiculo).success(function (veiculo) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('veiculo salvo com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        }
    }
	
	
	$scope.excluir = function () {
        if ($scope.veiculo.id == '') {
            alert('Selecione um veiculo');
        } else {
            $http.delete(url + '/' + $scope.veiculo.id).success(function (veiculo) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('veiculo excluído com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        }
    }
	
	$scope.seleciona = function(veiculoTabela) {
		$scope.veiculo = veiculoTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
});