package BDA.grupo1.repository;

import BDA.grupo1.model.Orden_zona_repartidor;

import java.util.List;

public interface Orden_Zona_repartidorRepository {
    public Orden_zona_repartidor crear(Orden_zona_repartidor ordenZonaRepartidor);
    public List<Orden_zona_repartidor> getAll();
    public String update(Orden_zona_repartidor ordenZonaRepartidor, Integer id);
    public void delete(Integer id);
}
