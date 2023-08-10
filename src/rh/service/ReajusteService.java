package rh.service;

import java.math.BigDecimal;
import java.util.List;

import rh.Funcionario;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        // Aplicando o DIP
        // Ao implementarmos o O do SOLID, não é automático, mas já somos induzidos a implementar o S e o D juntos.
        this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        // ValidacaoPercentualReajuste validacaoPercentualReajuste = new ValidacaoPercentualReajuste();
        // ValidacaoPeriodicidadeEntreReajuste validacaoPeriodicidadeEntreReajuste = new ValidacaoPeriodicidadeEntreReajuste();

        // validacaoPercentualReajuste.validar(funcionario, aumento);
        // validacaoPeriodicidadeEntreReajuste.validar(funcionario, aumento);


        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
