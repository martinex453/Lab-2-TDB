package BDA.grupo1.service;

import BDA.grupo1.model.Orden_zona_repartidor;
import BDA.grupo1.repository.Orden_Zona_repartidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Orden_zona_repartidorService {
    @Autowired
    private Orden_Zona_repartidorRepository orden_zona_repartidorRepository;

    public Orden_zona_repartidor crear(Orden_zona_repartidor ordenZonaRepartidor) {
        return orden_zona_repartidorRepository.crear(ordenZonaRepartidor);
    }

    public List<Orden_zona_repartidor> findAll() {
        return orden_zona_repartidorRepository.getAll();
    }

    public String update(Orden_zona_repartidor ordenZonaRepartidor, Integer id) {
        return orden_zona_repartidorRepository.update(ordenZonaRepartidor, id);
    }

    public void delete(Integer id) {
        orden_zona_repartidorRepository.delete(id);
    }
}
