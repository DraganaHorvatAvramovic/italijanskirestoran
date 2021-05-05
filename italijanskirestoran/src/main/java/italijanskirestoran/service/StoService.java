package italijanskirestoran.service;

import java.util.List;

import italijanskirestoran.model.Sto;

public interface StoService {
	
	Sto findOne(Long id);
	
	List<Sto> findAll();
	
	Sto save (Sto sto);
	
	Sto update (Sto sto);
	
	Sto delete (Long id);

}
