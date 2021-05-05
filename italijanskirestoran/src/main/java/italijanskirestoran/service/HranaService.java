package italijanskirestoran.service;

import java.util.List;

import italijanskirestoran.model.Hrana;

public interface HranaService {
	
	Hrana findOne(Long id);
	
	List<Hrana> findAll();
	
	Hrana save(Hrana hrana);
	
	Hrana update(Hrana hrana);
	
	Hrana delete(Long id);

}
