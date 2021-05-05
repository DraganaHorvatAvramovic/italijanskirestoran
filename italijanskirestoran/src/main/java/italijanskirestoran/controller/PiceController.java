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

import italijanskirestoran.dto.PiceDTO;
import italijanskirestoran.model.Pice;
import italijanskirestoran.service.PiceService;
import italijanskirestoran.support.PiceDtoToPice;
import italijanskirestoran.support.PiceToPiceDto;

@RestController
@RequestMapping(value = "/api/pica",produces = MediaType.APPLICATION_JSON_VALUE)
public class PiceController {
	
	@Autowired
	private PiceService piceService;
	
	@Autowired
	private PiceToPiceDto toPiceDto;
	
	@Autowired
	private PiceDtoToPice toPice;
	
	@GetMapping
	public ResponseEntity<List<PiceDTO>> getAll(){
		List<Pice> pica = piceService.findAll();
		
		return new ResponseEntity<>(toPiceDto.convert(pica),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PiceDTO> getOne(@PathVariable Long id){
		
		Pice pice = piceService.findOne(id);
		
		if(pice != null) {
			return new ResponseEntity<>(toPiceDto.convert(pice), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PiceDTO> update(@PathVariable Long id, @Valid @RequestBody PiceDTO piceDTO){
		if(!id.equals(piceDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Pice pice = toPice.convert(piceDTO);
		Pice sacuvanoPice = piceService.update(pice);
		
		return new ResponseEntity<>(toPiceDto.convert(sacuvanoPice), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PiceDTO> create(@Valid @RequestBody PiceDTO piceDTO){
		Pice pice = toPice.convert(piceDTO);
		Pice sacuvanoPice = piceService.save(pice);
		
		return new ResponseEntity<>(toPiceDto.convert(sacuvanoPice), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pice> delete(@PathVariable Long id){
		Pice obrisanoPice = piceService.delete(id);
		
		if(obrisanoPice != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
