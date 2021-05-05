package italijanskirestoran.service;

import java.util.List;

import italijanskirestoran.model.Stavka;

public interface StavkaService {
	
	Stavka findOne(Long id);	
	
	List<Stavka> findAll();
	
	Stavka save (Stavka stavka);
	
	Stavka update(Stavka stavka);
	
	Stavka delete(Long id);
	
	List<Stavka> find(Long id);
	
	Stavka saveStavka (Long porudzbinaId, Long hranaId, Long prilogId, Long piceId);

}
