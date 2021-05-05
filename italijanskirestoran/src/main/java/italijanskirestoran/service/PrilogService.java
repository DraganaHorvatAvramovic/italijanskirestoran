package italijanskirestoran.service;

import java.util.List;

import italijanskirestoran.model.Prilog;

public interface PrilogService {
	
	Prilog findOne(Long id);
	
	List<Prilog> findAll();
	
	Prilog save (Prilog prilog);
	
	Prilog update (Prilog prilog);
	
	Prilog delete (Long id);

}
