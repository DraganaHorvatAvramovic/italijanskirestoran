package italijanskirestoran.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import italijanskirestoran.dto.HranaDTO;
import italijanskirestoran.model.Hrana;
import italijanskirestoran.service.HranaService;
import italijanskirestoran.support.HranaDtoToHrana;
import italijanskirestoran.support.HranaToHranaDto;

@RestController
@RequestMapping(value = "/api/hrana",produces = MediaType.APPLICATION_JSON_VALUE)
public class HranaController {
	
	@Autowired
	private HranaService hranaSrvice;
	
	@Autowired
	private HranaToHranaDto toHranaDto;
	
	@Autowired
	private HranaDtoToHrana toHrana;
	
	@GetMapping
	public ResponseEntity<List<HranaDTO>> getAll(){
		List<Hrana> hrane = hranaSrvice.findAll();
		
		return new ResponseEntity<>(toHranaDto.convert(hrane), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HranaDTO> getOne(@PathVariable Long id){
		
		Hrana hrana = hranaSrvice.findOne(id);
		
		if(hrana != null) {
			return new ResponseEntity<>(toHranaDto.convert(hrana), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HranaDTO> update(@PathVariable Long id, @Valid @RequestBody HranaDTO hranaDTO){
		if(!id.equals(hranaDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Hrana hrana = toHrana.convert(hranaDTO);
		Hrana sacuvanaHrana = hranaSrvice.update(hrana);
		
		return new ResponseEntity<>(toHranaDto.convert(sacuvanaHrana), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HranaDTO> create(@Valid @RequestBody HranaDTO hranaDTO){
		Hrana hrana = toHrana.convert(hranaDTO);
		Hrana sacuvanaHrana = hranaSrvice.save(hrana);
		
		return new ResponseEntity<>(toHranaDto.convert(sacuvanaHrana), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Hrana> delete (@PathVariable Long id){
		Hrana obrisanaHrana = hranaSrvice.delete(id);
		
		if(obrisanaHrana != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
