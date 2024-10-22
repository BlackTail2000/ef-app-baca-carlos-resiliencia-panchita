package pe.edu.cibertec.ef_app_baca_carlos_resiliencia_panchita.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ef_app_baca_carlos_resiliencia_panchita.service.ReservaService;

@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    @CircuitBreaker(name = "panchita", fallbackMethod = "fallBackMethodErrorReserva")
    public String generarReserva() {
        return reservaService.reservaRandom();
    }

    public String fallBackMethodErrorReserva(Throwable throwable) {
        return "Error al generar la reserva. Intente de nuevo";
    }
}
