package com.prueba.neoris.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.prueba.neoris.entity.Persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "cliente")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteid;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "estado")
    private Boolean estado;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;
    /**@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Cuenta cuenta;**/
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movimiento> movimientos = new ArrayList<>();

}
