package BDA.grupo1.repository;

import BDA.grupo1.model.Repartidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RepartidorRepositoryImp implements RepartidorRepository{

    @Autowired
    private Sql2o sql2o;

    public Repartidor crear(Repartidor repartidor) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO repartidor (nombre, telefono) " +
                    "VALUES (:nombre, :telefono)";
            con.createQuery(sql)
                    .addParameter("nombre", repartidor.getNombre())
                    .addParameter("telefono", repartidor.getTelefono())
                    .executeUpdate();
            return repartidor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Repartidor> getAll() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM repartidor";
            return con.createQuery(sql).executeAndFetch(Repartidor.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String update(Repartidor repartidor, Integer id_repartidor) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE repartidor SET nombre = :nombre, telefono = :telefono" +
                    "WHERE id_repartidor = :id_repartidor";
            con.createQuery(sql)
                    .addParameter("id_repartidor", id_repartidor)
                    .addParameter("nombre", repartidor.getNombre())
                    .addParameter("telefono", repartidor.getTelefono())
                    .executeUpdate();
            return "Se actualizó con éxito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar";
        }
    }

    public void delete(Integer id_repartidor) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM repartidor WHERE id_repartidor = :id_repartidor";
            con.createQuery(sql)
                    .addParameter("id_repartidor", id_repartidor)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
