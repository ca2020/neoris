package com.prueba.neoris.service.impl;

import com.prueba.neoris.dto.CrearCuentaUsuarioDTO;
import com.prueba.neoris.dto.MovimientosDTO;
import com.prueba.neoris.entity.Cliente;
import com.prueba.neoris.entity.Cuenta;
import com.prueba.neoris.entity.Movimiento;
import com.prueba.neoris.repository.CuentaRepository;
import com.prueba.neoris.repository.MovimientoRepository;
import com.prueba.neoris.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoServiceImpl implements MovimientosService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    private MovimientosDTO converEntityToDto(Movimiento movimiento){
        MovimientosDTO movimientosDTO = new MovimientosDTO();
        movimientosDTO.setFecha(movimiento.getFecha());
        movimientosDTO.setNombre(movimiento.getCliente().getNombre());
        movimientosDTO.setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
        movimientosDTO.setTipoCuenta(movimiento.getCuenta().getTipoCuenta());
        movimientosDTO.setSaldoInicial(movimiento.getCuenta().getSaldoInicial());
        movimientosDTO.setEstado(movimiento.getCuenta().getEstado());
        movimientosDTO.setMovimiento(movimiento.getMovimiento());
        movimientosDTO.setSaldo(movimiento.getSaldo());
        return movimientosDTO;
    }
    public List<MovimientosDTO> obtenerTodos() throws Exception{
        return movimientoRepository.findAll()
                .stream()
                .map(this::converEntityToDto)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<MovimientosDTO> obtenerPorId(Long id) throws Exception {
        Optional<Movimiento> movimiento = movimientoRepository.findById(id);

        if (movimiento.isPresent()) {
            Movimiento movimientoNew = movimiento.get();
            MovimientosDTO movimientosDTO = converEntityToDto(movimientoNew);
            return Optional.of(movimientosDTO);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public MovimientosDTO crearCuenta(MovimientosDTO movimientosDTO) throws Exception{
        try {
            Cliente cliente = new Cliente();
            cliente.setClienteid(1L);
            Cuenta cuenta = new Cuenta();
            cuenta.setCuenta_id(1L);
            Movimiento movimiento = new Movimiento();
            movimiento.setCuenta(cuenta);
            movimiento.setCliente(cliente);
            movimiento.setFecha(movimientosDTO.getFecha());
            movimiento.getCliente().setNombre(movimientosDTO.getNombre());
            movimiento.getCuenta().setNumeroCuenta(movimientosDTO.getNumeroCuenta());
            movimiento.getCuenta().setTipoCuenta(movimientosDTO.getTipoCuenta());
            movimiento.getCuenta().setSaldoInicial(movimientosDTO.getSaldoInicial());
            movimiento.getCuenta().setEstado(movimientosDTO.getEstado());
            movimiento.setMovimiento(movimientosDTO.getMovimiento());
            movimiento.setSaldo(movimientosDTO.getSaldo());

            movimientoRepository.save(movimiento);

            return movimientosDTO;
            //return converEntityToDto(movimiento);
        } catch (Exception e) {
            throw new Exception("Error al crear el movimiento: " + e.getMessage());
        }

    }

    @Override
    public Optional<MovimientosDTO> actualizarCuenta(Long id, MovimientosDTO movimientosDTO) throws Exception {
        try {
            Optional<Movimiento> movimientoOptional = movimientoRepository.findById(id);
            if (movimientoOptional.isPresent()) {
                Cliente cliente = new Cliente();
                cliente.setClienteid(1L);
                Cuenta cuenta = new Cuenta();
                cuenta.setCuenta_id(1L);
                Movimiento movimiento = new Movimiento();
                movimiento.setCuenta(cuenta);
                movimiento.setCliente(cliente);
                movimiento.setFecha(movimientosDTO.getFecha());
                movimiento.getCliente().setNombre(movimientosDTO.getNombre());
                movimiento.getCuenta().setNumeroCuenta(movimientosDTO.getNumeroCuenta());
                movimiento.getCuenta().setTipoCuenta(movimientosDTO.getTipoCuenta());
                movimiento.getCuenta().setSaldoInicial(movimientosDTO.getSaldoInicial());
                movimiento.getCuenta().setEstado(movimientosDTO.getEstado());
                movimiento.setMovimiento(movimientosDTO.getMovimiento());
                movimiento.setSaldo(movimientosDTO.getSaldo());

                movimientoRepository.save(movimiento);

                return Optional.of(converEntityToDto(movimiento));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar la cuenta de usuario: " + e.getMessage());
        }
    }


    @Override
    public void eliminarCuenta(Long id) throws Exception {
        try {
            Optional<Movimiento> movimiento = movimientoRepository.findById(id);
            if (movimiento.isPresent()) {
                movimientoRepository.delete(movimiento.get());
            } else {
                throw new Exception("No se ha encontrado la cuenta con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar la cuenta de usuario con id " + id + ": " + e.getMessage());
        }
    }
}
