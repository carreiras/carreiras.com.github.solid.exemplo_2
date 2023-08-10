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
        // Como deveria ser esta classe sem o OCP
        // this.validacoes.forEach(v -> v.validar(funcionario, aumento));

        ValidacaoPercentualReajuste validacaoPercentualReajuste = new ValidacaoPercentualReajuste();
        ValidacaoPeriodicidadeEntreReajuste validacaoPeriodicidadeEntreReajuste = new ValidacaoPeriodicidadeEntreReajuste();

        validacaoPercentualReajuste.validar(funcionario, aumento);
        validacaoPeriodicidadeEntreReajuste.validar(funcionario, aumento);

        // Ao aplicar o OCP, automaticamente aplicou-se o DIP

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
