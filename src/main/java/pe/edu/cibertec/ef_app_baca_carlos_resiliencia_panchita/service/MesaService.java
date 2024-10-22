package pe.edu.cibertec.ef_app_baca_carlos_resiliencia_panchita.service;

import org.springframework.stereotype.Service;

@Service
public class MesaService {

    public String mesasDisponibles(Integer idSucursal) {
        if(idSucursal < 1) {
            throw new RuntimeException("Error en la llamada.");
        } else {
            int random = (int) (Math.random() * 21);
            return "Mesas Disponibles: " + random;
        }
    }
}
