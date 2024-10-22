package pe.edu.cibertec.ef_app_baca_carlos_resiliencia_panchita.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ef_app_baca_carlos_resiliencia_panchita.service.MesaService;

@RestController
@RequestMapping("/mesa")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping("/{idSucursal}/disponibles")
    @CircuitBreaker(name = "panchita", fallbackMethod = "fallBackMethodNoExisteSucursal")
    public String mesasDisponiblesPorSucursal(@PathVariable("idSucursal") Integer idSucursal) {
        return mesaService.mesasDisponibles(idSucursal);
    }

    public String fallBackMethodNoExisteSucursal(Integer idSucursal, Throwable throwable) {
        return "ID de Sucursal no válido.";
    }
}
