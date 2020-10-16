package com.cobenapp.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cobenapp.domain.Proveedores;
import com.cobenapp.dto.ProveedoresDTO;
import com.cobenapp.mapper.ProveerdoresMapper;
import com.cobenapp.service.ProveedoresService;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin("*")
public class ProveedoresController {
	
	public static Logger log=LoggerFactory.getLogger(ProveedoresController.class);
	
	//Iyeccion de dependencia
	@Autowired
	ProveedoresService porveedoresService;
	
	@Autowired
	ProveerdoresMapper proveedoresMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody ProveedoresDTO proveedoresDTO) throws Exception{
		
		Proveedores proveedores=proveedoresMapper.toProveedro(proveedoresDTO);
		proveedores=porveedoresService.update(proveedores);
		
		return ResponseEntity.ok().body(proveedoresDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ProveedoresDTO proveedoresDTO) throws Exception{
		
		Proveedores proveedores=proveedoresMapper.toProveedro(proveedoresDTO);
		proveedores=porveedoresService.update(proveedores);
		
		return ResponseEntity.ok().body(proveedoresDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{idProvd}")
	public ResponseEntity<?> delete(@PathVariable("idProvd") Integer idProvd) throws Exception{
		
		porveedoresService.deleteById(idProvd);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<Proveedores> proveedores=porveedoresService.findAll();
		///se crea una lista de asociadosDTO
		List<ProveedoresDTO> proveedoresDTOS=proveedoresMapper.toProveedoresDTO(proveedores);
		
		return ResponseEntity.ok().body(proveedoresDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{idProvd}")
	public ResponseEntity<?> findById(@PathVariable("idProvd") Integer idProvd) throws Exception{
		
		Optional<Proveedores> proveedoresOptional=porveedoresService.findById(idProvd);
		if(proveedoresOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Proveedor Not Found");	
		}
		
		Proveedores proveedores=proveedoresOptional.get();
		
		ProveedoresDTO proveedoresDTO=proveedoresMapper.toPorveedorDTO(proveedores);
		
		return ResponseEntity.ok().body(proveedoresDTO);
	}


}
