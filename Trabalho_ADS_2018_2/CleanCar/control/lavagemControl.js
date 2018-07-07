var app = angular.module('lavagemModule',[]);
var url = 'http://localhost:8080/CleanCarServer/rs/lavagem';

app.controller('lavagemControl',function($scope, $http){
	
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (lavagemsRetorno) {
			$scope.lavagems = lavagemsRetorno;
		}).error(function (menssagemErro) {
			alert(menssagemErro);
		});
	}
	
	$scope.pesquisarVeicuos = function(){
		$http.get('http://localhost:8080/CleanCarServer/rs/veiculo').success(function (veiculosRetorno) {
			$scope.veiculos = veiculosRetorno;
		}).error(function (menssagemErro) {
			alert(menssagemErro);
		});
	}
	
	$scope.pesquisarEstabelecimento = function(){
		$http.get('http://localhost:8080/CleanCarServer/rs/estabelecimento').success(function (estabelecimentoRetorno) {
			$scope.estabelecimentos = estabelecimentoRetorno;
		}).error(function (menssagemErro) {
			alert(menssagemErro);
		});
	}
	
 $scope.novo = function () {
        $scope.lavagem = {};
        $scope.lavagem.id = '';
        //$scope.pessoa.telefones = [];
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
        if ($scope.lavagem.id == null) {
            $http.post(url, $scope.lavagem).success(function (lavagem) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('lavagem salvo com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        } else {
            $http.put(url, $scope.lavagem).success(function (lavagem) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('lavagem salvo com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        }
    }

    $scope.excluir = function () {
        if ($scope.lavagem.id == '') {
            alert('Selecione um lavagem');
        } else {
            $http.delete(url + '/' + $scope.lavagem.id).success(function (lavagem) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('lavagem excluído com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        }
    }

    $scope.seleciona = function (lavagemTabela) {
        $scope.lavagem = lavagemTabela;
    }

    $scope.pesquisar();
    $scope.novo();
	$scope.pesquisarVeicuos();
	$scope.pesquisarEstabelecimento();
});