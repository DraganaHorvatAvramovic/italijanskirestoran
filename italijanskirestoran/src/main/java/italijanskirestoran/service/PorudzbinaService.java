package italijanskirestoran.service;

import java.util.List;

import org.springframework.data.domain.Page;

import italijanskirestoran.model.Porudzbina;

public interface PorudzbinaService {
	
	Porudzbina findOne(Long id);
	
	List<Porudzbina> findAll();
	
	Porudzbina save(Porudzbina porudzbina);
	
	Porudzbina update(Porudzbina porudzbina);
	
	Porudzbina delete(Long id);
	
	Page<Porudzbina> pretraga(Long stoId, int pageNo);

}
