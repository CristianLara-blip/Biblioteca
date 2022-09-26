package upeu.edu.pe.pybiblioteca.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.pybiblioteca.entity.Detalle;
import upeu.edu.pe.pybiblioteca.service.DetalleService;

@RestController
@RequestMapping("/api/detalles")
public class DetalleController {
	
	@Autowired
	private DetalleService service;
	
	@GetMapping("/all")
	public List<Detalle> readAll(){		
		return service.reaAll();
	}
	@GetMapping("/{id}")
	public Detalle read(@PathVariable int id){		
		return service.read(id);
	}
	@PostMapping("/save")
	public int save(@RequestBody Detalle detalle){		
		return service.create(detalle);
	}
	@PutMapping("/update")
	public int update(@PathVariable int id, @RequestBody Detalle detalle){	
		Detalle d = service.read(id);
		return service.update(d);
	}
	
	@DeleteMapping("/del/{id}")
	public int save(@PathVariable int id){		
		return service.delete(id);
	}
}
