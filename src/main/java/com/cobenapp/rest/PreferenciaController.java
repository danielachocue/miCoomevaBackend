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

import com.cobenapp.domain.Preferencias;
import com.cobenapp.dto.PreferenciasDTO;
import com.cobenapp.mapper.PreferenciasMapper;
import com.cobenapp.service.PreferenciasService;

@RestController
@RequestMapping("/api/preferencias")
@CrossOrigin("*")
public class PreferenciaController {
	
	public static Logger log=LoggerFactory.getLogger(PreferenciaController.class);
	
	//Iyeccion de dependencia
	@Autowired
	PreferenciasService preferenciasService;
	
	@Autowired
	PreferenciasMapper prefereneciasMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody PreferenciasDTO preferenciasDTO) throws Exception{
		
		Preferencias preferencias=prefereneciasMapper.toPreferencia(preferenciasDTO);
		preferencias=preferenciasService.update(preferencias);
		
		return ResponseEntity.ok().body(preferenciasDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody PreferenciasDTO preferenciasDTO) throws Exception{
		
		Preferencias preferencias=prefereneciasMapper.toPreferencia(preferenciasDTO);
		preferencias=preferenciasService.update(preferencias);
		
		return ResponseEntity.ok().body(preferenciasDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{idprdfcs}")
	public ResponseEntity<?> delete(@PathVariable("idprdfcs") Integer idprdfcs) throws Exception{
		
		preferenciasService.deleteById(idprdfcs);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<Preferencias> preferencias=preferenciasService.findAll();
		///se crea una lista de asociadosDTO
		List<PreferenciasDTO> preferenciasDTOS=prefereneciasMapper.toPreferenciasDTO(preferencias);
		
		return ResponseEntity.ok().body(preferenciasDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{idprdfcs}")
	public ResponseEntity<?> findById(@PathVariable("idprdfcs") Integer idprdfcs) throws Exception{
		
		Optional<Preferencias> preferneciasOptional=preferenciasService.findById(idprdfcs);
		if(preferneciasOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Preferencia Not Found");	
		}
		
		Preferencias preferencias=preferneciasOptional.get();
		
		PreferenciasDTO preferenciasDTO=prefereneciasMapper.toPreferenciaDTO(preferencias);
		
		return ResponseEntity.ok().body(preferenciasDTO);
	}

}
