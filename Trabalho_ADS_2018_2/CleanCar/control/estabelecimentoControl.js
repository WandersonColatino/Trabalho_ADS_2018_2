var app = angular.module('estabelecimentoModule',[]);
var url = 'http://localhost:8080/CleanCarServer/rs/estabelecimento';

app.controller('estabelecimentoControl',function($scope, $http){
	
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (estabelecimentosRetorno) {
			$scope.estabelecimentos = estabelecimentosRetorno;
		}).error(function (menssagemErro) {
			alert(menssagemErro);
		});
	}
	
 $scope.novo = function () {
        $scope.estabelecimento = {};
        $scope.estabelecimento.id = '';
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
        if ($scope.estabelecimento.id == null) {
            $http.post(url, $scope.estabelecimento).success(function (estabelecimento) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('estabelecimento salvo com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        } else {
            $http.put(url, $scope.estabelecimento).success(function (estabelecimento) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('estabelecimento salvo com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        }
    }

    $scope.excluir = function () {
        if ($scope.estabelecimento.id == '') {
            alert('Selecione um estabelecimento');
        } else {
            $http.delete(url + '/' + $scope.estabelecimento.id).success(function (estabelecimento) {
                $scope.pesquisar();
                $scope.novo();
                $scope.mensagens.push('estabelecimento excluído com sucesso');
            }).error(function (erro) {
                alert(erro);
            });
        }
    }

    $scope.seleciona = function (estabelecimentoTabela) {
        $scope.estabelecimento = estabelecimentoTabela;
    }

    $scope.pesquisar();
    $scope.novo();
});