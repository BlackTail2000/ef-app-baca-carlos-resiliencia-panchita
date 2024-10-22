package pe.edu.cibertec.ef_app_baca_carlos_resiliencia_panchita.service;

import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    public String reservaRandom() {
        int random = (int) (Math.random() * 2);
        if(random == 0) {
            throw new RuntimeException("Error en la llamada.");
        }
        return "Reserva generada. Lo esperamos.";
    }
}
