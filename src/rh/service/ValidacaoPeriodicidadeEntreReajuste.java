package rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import rh.Funcionario;
import rh.exception.ValidacaoException;

public class ValidacaoPeriodicidadeEntreReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser no minimo de 6 meses!");
        }
    }
}
