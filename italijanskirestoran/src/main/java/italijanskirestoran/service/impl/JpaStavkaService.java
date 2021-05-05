package italijanskirestoran.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import italijanskirestoran.model.Stavka;
import italijanskirestoran.repository.StavkaRepository;
import italijanskirestoran.service.StavkaService;

@Service
public class JpaStavkaService implements StavkaService {

	@Autowired
	private StavkaRepository stavkaRepository;
	
	@Override
	public Stavka findOne(Long id) {
		return stavkaRepository.findOneById(id);
	}

	@Override
	public List<Stavka> findAll() {
		return stavkaRepository.findAll();
	}


	@Override
	public Stavka save(Stavka stavka) {
		return stavkaRepository.save(stavka);
	}



	@Override
	public Stavka update(Stavka stavka) {
		return stavkaRepository.save(stavka);
	}
	
	@Override
	public Stavka delete(Long id) {
		Optional<Stavka> stavka = stavkaRepository.findById(id);
		if(stavka.isPresent()) {
			stavkaRepository.deleteById(id);
			return stavka.get();
		}
		return null;
	}

	@Override
	public List<Stavka> find(Long id) {
		return stavkaRepository.findByPorudzbinaId(id);
	}

	@Override
	public Stavka saveStavka(Long porudzbinaId, Long hranaId, Long prilogId, Long piceId) {
		return stavkaRepository.findByPorudzbinaIdAndHranaIdAndPrilogIdAndPiceId(porudzbinaId, hranaId, prilogId, piceId);
	}



}
