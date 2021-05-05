package italijanskirestoran.service;

import java.util.List;

import italijanskirestoran.model.Pice;

public interface PiceService {
	
	Pice findOne(Long id);
	
	List<Pice> findAll();
	
	Pice save (Pice pice);
	
	Pice update (Pice pice);
	
	Pice delete (Long id);

}
