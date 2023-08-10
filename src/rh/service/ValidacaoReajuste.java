package rh.service;

import java.math.BigDecimal;

import rh.Funcionario;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal aumento);
}
