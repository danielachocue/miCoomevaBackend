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

import com.cobenapp.domain.UbicacionBeneficios;
import com.cobenapp.dto.UbicacionBeneficiosDTO;
import com.cobenapp.mapper.UbicacionBeneficiosMapper;
import com.cobenapp.service.UbicacionBeneficiosService;

@RestController
@RequestMapping("/api/ubicacionBeneficios")
@CrossOrigin("*")
public class UbicacionBeneficioController {
	
	public static Logger log=LoggerFactory.getLogger(UbicacionBeneficioController.class);
	
	//Iyeccion de dependencia
	@Autowired
	UbicacionBeneficiosService ubicacionBeneficiosService;
	
	@Autowired
	UbicacionBeneficiosMapper ubicacionBeneficioMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody UbicacionBeneficiosDTO ubicacionBeneficioDTO) throws Exception{
		
		UbicacionBeneficios ubicacionBeneficios=ubicacionBeneficioMapper.toUbicacionBeneficio(ubicacionBeneficioDTO);
		ubicacionBeneficios=ubicacionBeneficiosService.update(ubicacionBeneficios);
		
		return ResponseEntity.ok().body(ubicacionBeneficioDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody UbicacionBeneficiosDTO ubicacionBeneficioDTO) throws Exception{
		
		UbicacionBeneficios ubicacionBeneficios=ubicacionBeneficioMapper.toUbicacionBeneficio(ubicacionBeneficioDTO);
		ubicacionBeneficios=ubicacionBeneficiosService.update(ubicacionBeneficios);
		
		return ResponseEntity.ok().body(ubicacionBeneficioDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{idUb}")
	public ResponseEntity<?> delete(@PathVariable("idUb") Integer idUb) throws Exception{
		
		ubicacionBeneficiosService.deleteById(idUb);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<UbicacionBeneficios> ubicacionBeneficios=ubicacionBeneficiosService.findAll();
		///se crea una lista de asociadosDTO
		List<UbicacionBeneficiosDTO> ubicacionBeneficiosDTOS=ubicacionBeneficioMapper.toUbicacionBeneficiosDTO(ubicacionBeneficios);
		
		return ResponseEntity.ok().body(ubicacionBeneficiosDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{idTipo}")
	public ResponseEntity<?> findById(@PathVariable("idTipo") Integer idTipo) throws Exception{
		
		Optional<UbicacionBeneficios> ubicacionBeneficiosOptional=ubicacionBeneficiosService.findById(idTipo);
		if(ubicacionBeneficiosOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Ubicacion de Beneficio Not Found");	
		}
		
		UbicacionBeneficios ubicacionBeneficios=ubicacionBeneficiosOptional.get();
		
		UbicacionBeneficiosDTO ubicacionBeneficiosDTO=ubicacionBeneficioMapper.toUbicacionBeneficioDTO(ubicacionBeneficios);
		
		return ResponseEntity.ok().body(ubicacionBeneficiosDTO);
	}


}
