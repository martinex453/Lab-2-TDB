package BDA.grupo1.controller;

import BDA.grupo1.model.Empresa;
import BDA.grupo1.service.ClienteSesionService;
import BDA.grupo1.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@CrossOrigin
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ClienteSesionService clienteSesionService;

    @PostMapping("/empresa/crear")
    public Empresa crearEmpresa(@RequestBody Empresa empresa, @RequestParam Integer id){
        clienteSesionService.crear(id);
        return empresaService.crear(empresa);
    }

    @GetMapping("/empresa/All")
    public List<Empresa> getAllEmpresa(){return empresaService.findAll();}

    @PostMapping("/empresa/update/{id}")
    public String updateEmpresa(@RequestBody Empresa empresa, @PathVariable Integer id, @RequestParam Integer id_cliente){
        clienteSesionService.crear(id_cliente);
        return empresaService.update(empresa,id);
    }

    @DeleteMapping("/empresa/delete/{id}")
    public void deleteEmpresa(@PathVariable Integer id, @RequestParam Integer id_cliente){
        clienteSesionService.crear(id_cliente);
        empresaService.delete(id);
    }

    @GetMapping("/empresa/area_zonas")
    public Double areaZonas(@RequestBody Empresa empresa){
        return empresaService.areaZona(empresa.getId_empresa());
    }
}
