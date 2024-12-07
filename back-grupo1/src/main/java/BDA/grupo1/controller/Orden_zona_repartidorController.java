package BDA.grupo1.controller;

import BDA.grupo1.model.Orden_zona_repartidor;
import BDA.grupo1.service.ClienteSesionService;
import BDA.grupo1.service.Orden_zona_repartidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Orden_zona_repartidorController {
    @Autowired
    private Orden_zona_repartidorService orden_zona_repartidorService;

    @Autowired
    private ClienteSesionService clienteSesionService;

    @PostMapping("/OrdenZonaRepartidor/crear")
    public Orden_zona_repartidor crearOrden_zona_repartidor(@RequestBody Orden_zona_repartidor ordenZonaRepartidor, @RequestParam Integer id_cliente){
        clienteSesionService.crear(id_cliente);
        return orden_zona_repartidorService.crear(ordenZonaRepartidor);
    }

    @GetMapping("/OrdenZonaRepartidor/All")
    public List<Orden_zona_repartidor> getAllOrden_zona_repartidor(){ return orden_zona_repartidorService.findAll();}

    @PostMapping("/OrdenZonaRepartidor/update/{id}")
    public String updateOrden_zona_repartidor(@RequestBody Orden_zona_repartidor ordenZonaRepartidor, @PathVariable Integer id, @RequestParam Integer id_cliente){
        clienteSesionService.crear(id_cliente);
        return orden_zona_repartidorService.update(ordenZonaRepartidor,id);
    }

    @DeleteMapping("/OrdenZonaRepartidor/delete/{id}")
    public void deleteOrden_zona_repartidor(@PathVariable Integer id, @RequestParam Integer id_cliente){
        clienteSesionService.crear(id_cliente);
        orden_zona_repartidorService.delete(id);
    }
}
