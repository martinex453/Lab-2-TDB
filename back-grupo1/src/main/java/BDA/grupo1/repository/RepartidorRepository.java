package BDA.grupo1.repository;

import BDA.grupo1.model.Repartidor;

import java.util.List;

public interface RepartidorRepository {
    public Repartidor crear(Repartidor repartidor);
    public List<Repartidor> getAll();
    public String update(Repartidor repartidor, Integer id);
    public void delete(Integer id);
}
