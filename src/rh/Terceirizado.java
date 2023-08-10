package rh;

import java.math.BigDecimal;

public class Terceirizado extends Funcionario {

    private String empresa;

    public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        super(nome, cpf, cargo, salario);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public void atualizarSalario(BigDecimal novoSalario) {
        // ficaria vazio ou executaria uma Exception
    }

    @Override
    public void promover(Cargo novoCargo) {
        // ficaria vazio ou executaria uma Exception
    }
}
