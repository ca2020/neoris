package com.prueba.neoris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientosDTO {

    private Date fecha;
    private String nombre;
    private Long numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private Double movimiento;
    private Double saldo;


}
