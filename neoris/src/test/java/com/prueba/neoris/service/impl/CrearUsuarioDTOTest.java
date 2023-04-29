package com.prueba.neoris.service.impl;

import com.prueba.neoris.dto.CrearUsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrearUsuarioDTOTest {
    @Mock
    private CrearUsuarioDTO crearUsuarioDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        crearUsuarioDTO = CrearUsuarioDTO.builder()
                .nombre("Carlos")
                .direccion("Calle")
                .telefono("123")
                .contraseña("123")
                .estado(true)
                .build();
    }

    @Test
    void testCrearUsuarioDTO() {
        Assertions.assertNotNull(crearUsuarioDTO);
        Assertions.assertEquals("Carlos", crearUsuarioDTO.getNombre());
        Assertions.assertEquals("Calle", crearUsuarioDTO.getDireccion());
        Assertions.assertEquals("123", crearUsuarioDTO.getTelefono());
        Assertions.assertEquals("123", crearUsuarioDTO.getContraseña());
        Assertions.assertTrue(crearUsuarioDTO.getEstado());
    }
}
