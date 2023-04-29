package com.prueba.neoris.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "movimientos")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimiento_id;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "tipomovimiento")
    private Double movimiento;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "saldo")
    private Double saldo;
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


}
