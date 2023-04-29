package com.prueba.neoris.service.impl;

import com.prueba.neoris.dto.CrearCuentaUsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
public class CrearCuentaUsuarioDTOTest {
    @Mock
    private CrearCuentaUsuarioDTO crearCuentaUsuarioDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        crearCuentaUsuarioDTO = new CrearCuentaUsuarioDTO(123456L, "Ahorros", 1000.0, true, "Juan");
    }

    @Test
    void testCrearCuentaUsuarioDTO() {
        Assertions.assertNotNull(crearCuentaUsuarioDTO);
        Assertions.assertEquals(123456L, crearCuentaUsuarioDTO.getNumeroCuenta());
        Assertions.assertEquals("Ahorros", crearCuentaUsuarioDTO.getTipo());
        Assertions.assertEquals(1000.0, crearCuentaUsuarioDTO.getSaldoInicial());
        Assertions.assertTrue(crearCuentaUsuarioDTO.getEstado());
        Assertions.assertEquals("Juan", crearCuentaUsuarioDTO.getNombre());
    }


}
