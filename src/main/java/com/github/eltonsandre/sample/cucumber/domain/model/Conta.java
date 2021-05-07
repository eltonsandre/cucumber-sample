package com.github.eltonsandre.sample.cucumber.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author eltonsandre
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta {

    @EqualsAndHashCode.Include
    private String dono;

    @EqualsAndHashCode.Include
    private String banco;

    @EqualsAndHashCode.Include
    private String agencia;

    @EqualsAndHashCode.Include
    private String numero;

    private BigDecimal saldo;
    private BigDecimal limite;

    boolean temSaldoSuficiente(final BigDecimal valor) {
        return this.saldo.compareTo(valor) < 0;
    }

    public boolean sacar(final BigDecimal valor) {
        if (this.temSaldoSuficiente(valor)) {
            return false;
        }

        this.saldo = this.saldo.subtract(valor);// Pode sacar
        return true;
    }

    public boolean depositar(final BigDecimal quantidade) {
        final var valor = this.saldo.add(quantidade);

        if (this.temlimite(valor)) {
            return false;
        }

        this.saldo = valor;// Pode depositar
        return true;
    }

    public boolean temlimite(final BigDecimal valor) {
        return this.limite.compareTo(valor) > -1;
    }


}
