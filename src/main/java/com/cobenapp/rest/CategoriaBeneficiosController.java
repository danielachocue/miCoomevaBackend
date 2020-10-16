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

import com.cobenapp.domain.CategoriaBeneficios;
import com.cobenapp.dto.CategoriaBeneficiosDTO;
import com.cobenapp.mapper.CategoriaBeneficiosMapper;
import com.cobenapp.service.CategoriaBeneficiosService;

@RestController
@RequestMapping("/api/categoriaBeneficios")
@CrossOrigin("*")
public class CategoriaBeneficiosController {
	
	
	public static Logger log=LoggerFactory.getLogger(CategoriaBeneficiosController.class);
	
	//Iyeccion de dependencia
	@Autowired
	CategoriaBeneficiosService categoriaBeneficiosService;
	
	@Autowired
	CategoriaBeneficiosMapper categoriaBeneficiosMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody CategoriaBeneficiosDTO categoriaBeneficiosDTO) throws Exception{
		
		CategoriaBeneficios categoriaBeneficios=categoriaBeneficiosMapper.toCategoriaBeneficio(categoriaBeneficiosDTO);
		categoriaBeneficios=categoriaBeneficiosService.update(categoriaBeneficios);
		
		return ResponseEntity.ok().body(categoriaBeneficiosDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody CategoriaBeneficiosDTO categoriaBeneficiosDTO) throws Exception{
		
		CategoriaBeneficios categoriaBeneficios=categoriaBeneficiosMapper.toCategoriaBeneficio(categoriaBeneficiosDTO);
		categoriaBeneficios=categoriaBeneficiosService.update(categoriaBeneficios);
		
		return ResponseEntity.ok().body(categoriaBeneficiosDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{idCat}")
	public ResponseEntity<?> delete(@PathVariable("idCat") Integer idCat) throws Exception{
		
		categoriaBeneficiosService.deleteById(idCat);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<CategoriaBeneficios> categoriaBeneficios=categoriaBeneficiosService.findAll();
		///se crea una lista de asociadosDTO
		List<CategoriaBeneficiosDTO> categoriaBeneficiosDTOS=categoriaBeneficiosMapper.toCategoriaBeneficiosDTO(categoriaBeneficios);
		
		return ResponseEntity.ok().body(categoriaBeneficiosDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{idCat}")
	public ResponseEntity<?> findById(@PathVariable("idCat") Integer idCat) throws Exception{
		
		Optional<CategoriaBeneficios> categoriaBeneficiosOptional=categoriaBeneficiosService.findById(idCat);
		if(categoriaBeneficiosOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Categoria Beneficos Not Found");	
		}
		
		CategoriaBeneficios categoriaBeneficios=categoriaBeneficiosOptional.get();
		
		CategoriaBeneficiosDTO categoriaBeneficiosDTO=categoriaBeneficiosMapper.toCategoriaBeneficioDTO(categoriaBeneficios);
		
		return ResponseEntity.ok().body(categoriaBeneficiosDTO);
	}

}
