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

import com.cobenapp.domain.UsoBeneficio;
import com.cobenapp.dto.UsoBeneficioDTO;
import com.cobenapp.mapper.UsoBeneficiosMapper;
import com.cobenapp.service.UsoBeneficioService;

@RestController
@RequestMapping("/api/usoBeneficios")
@CrossOrigin("*")
public class UsoBeneficosController {
	
	public static Logger log=LoggerFactory.getLogger(UsoBeneficosController.class);
	
	//Iyeccion de dependencia
	@Autowired
	UsoBeneficioService usoBeneficiosService;
	
	@Autowired
	UsoBeneficiosMapper usoBeneficioMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody UsoBeneficioDTO usoBeneficioDTO) throws Exception{
		
		UsoBeneficio usoBeneficios=usoBeneficioMapper.toUsoBeneficio(usoBeneficioDTO);
		usoBeneficios=usoBeneficiosService.update(usoBeneficios);
		
		return ResponseEntity.ok().body(usoBeneficioDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody UsoBeneficioDTO usoBeneficioDTO) throws Exception{
		
		UsoBeneficio usoBeneficios=usoBeneficioMapper.toUsoBeneficio(usoBeneficioDTO);
		usoBeneficios=usoBeneficiosService.update(usoBeneficios);
		
		return ResponseEntity.ok().body(usoBeneficioDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{idUso}")
	public ResponseEntity<?> delete(@PathVariable("idUso") Integer idUso) throws Exception{
		
		usoBeneficiosService.deleteById(idUso);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<UsoBeneficio> usoBeneficios=usoBeneficiosService.findAll();
		///se crea una lista de asociadosDTO
		List<UsoBeneficioDTO> usoBeneficiosDTOS=usoBeneficioMapper.toUsoBeneficiosDTO(usoBeneficios);
		
		return ResponseEntity.ok().body(usoBeneficiosDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{idUso}")
	public ResponseEntity<?> findById(@PathVariable("idUso") Integer idUso) throws Exception{
		
		Optional<UsoBeneficio> usoBeneficiosOptional=usoBeneficiosService.findById(idUso);
		if(usoBeneficiosOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Uso del Beneficio Not Found");	
		}
		
		UsoBeneficio usoBeneficios=usoBeneficiosOptional.get();
		
		UsoBeneficioDTO usoBeneficiosDTO=usoBeneficioMapper.toUsoBeneficioDTO(usoBeneficios);
		
		return ResponseEntity.ok().body(usoBeneficiosDTO);
	}



}
