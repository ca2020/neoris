package com.prueba.neoris.dto;

import com.prueba.neoris.entity.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearUsuarioDTO {

    private String nombre;
    private String direccion;
    private String telefono;
    private String contraseña;
    private Boolean estado;

}
