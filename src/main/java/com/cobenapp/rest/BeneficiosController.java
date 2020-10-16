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

import com.cobenapp.domain.Beneficios;
import com.cobenapp.dto.BeneficiosDTO;
import com.cobenapp.mapper.BeneficiosMapper;
import com.cobenapp.service.BeneficiosService;

@RestController
@RequestMapping("/api/beneficios")
@CrossOrigin("*")
public class BeneficiosController {
	
	public static Logger log=LoggerFactory.getLogger(BeneficiosController.class);
	
	//Iyeccion de dependencia
	@Autowired
	BeneficiosService beneficiosService;
	
	@Autowired
	BeneficiosMapper beneficiosMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody BeneficiosDTO beneficiosDTO) throws Exception{
		
		Beneficios beneficios=beneficiosMapper.toBeneficio(beneficiosDTO);
		beneficios=beneficiosService.update(beneficios);
		
		return ResponseEntity.ok().body(beneficiosDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody BeneficiosDTO beneficiosDTO) throws Exception{
		
		Beneficios beneficios=beneficiosMapper.toBeneficio(beneficiosDTO);
		beneficios=beneficiosService.update(beneficios);
		
		return ResponseEntity.ok().body(beneficiosDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{idBeneficio}")
	public ResponseEntity<?> delete(@PathVariable("idBeneficio") Integer idBeneficio) throws Exception{
		
		beneficiosService.deleteById(idBeneficio);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<Beneficios> beneficios=beneficiosService.findAll();
		///se crea una lista de asociadosDTO
		List<BeneficiosDTO> beneficiosDTOS=beneficiosMapper.toBeneficiosDTO(beneficios);
		
		return ResponseEntity.ok().body(beneficiosDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{idBeneficio}")
	public ResponseEntity<?> findById(@PathVariable("documento") Integer idBeneficio) throws Exception{
		
		Optional<Beneficios> beneficiosOptional=beneficiosService.findById(idBeneficio);
		if(beneficiosOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Beneficios Not Found");	
		}
		
		Beneficios beneficios=beneficiosOptional.get();
		
		BeneficiosDTO beneficiosDTO=beneficiosMapper.toBeneficioDTO(beneficios);
		
		return ResponseEntity.ok().body(beneficiosDTO);
	}

}
