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

import com.cobenapp.domain.Asociados;
import com.cobenapp.dto.AsociadosDTO;
import com.cobenapp.mapper.AsociadosMapper;
import com.cobenapp.service.AsociadosService;

@RestController
@RequestMapping("/api/asociados")
@CrossOrigin("*")
public class AsociadosController {
	
	public static Logger log=LoggerFactory.getLogger(AsociadosController.class);
	
	//Iyeccion de dependencia
	@Autowired
	AsociadosService asociadosService;
	
	@Autowired
	AsociadosMapper asociadosMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody AsociadosDTO asociadosDTO) throws Exception{
		
		Asociados asociados=asociadosMapper.toAsociado(asociadosDTO);
		asociados=asociadosService.update(asociados);
		
		return ResponseEntity.ok().body(asociadosDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody AsociadosDTO asociadosDTO) throws Exception{
		
		Asociados asociados=asociadosMapper.toAsociado(asociadosDTO);
		asociados=asociadosService.update(asociados);
		
		return ResponseEntity.ok().body(asociadosDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{documento}")
	public ResponseEntity<?> delete(@PathVariable("documento") String documento) throws Exception{
		
		asociadosService.deleteById(documento);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<Asociados> asociados=asociadosService.findAll();
		///se crea una lista de asociadosDTO
		List<AsociadosDTO> asociadosDTOS=asociadosMapper.toAsociadosDTO(asociados);
		
		return ResponseEntity.ok().body(asociadosDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{documento}")
	public ResponseEntity<?> findById(@PathVariable("documento") String documento) throws Exception{
		
		Optional<Asociados> asociadosOptional=asociadosService.findById(documento);
		if(asociadosOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Asociado Not Found");	
		}
		
		Asociados asociados=asociadosOptional.get();
		
		AsociadosDTO asociadosDTO=asociadosMapper.toAsociadoDTO(asociados);
		
		return ResponseEntity.ok().body(asociadosDTO);
	}

}
