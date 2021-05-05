package italijanskirestoran.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import italijanskirestoran.model.Sto;
import italijanskirestoran.repository.StoRepository;
import italijanskirestoran.service.StoService;

@Service
public class JpaStoService implements StoService{

	@Autowired
	private StoRepository stoRepository;
	
	@Override
	public Sto findOne(Long id) {
		return stoRepository.findOneById(id);
	}

	@Override
	public List<Sto> findAll() {
		return stoRepository.findAll();
	}

	@Override
	public Sto save(Sto sto) {
		return stoRepository.save(sto);
	}

	@Override
	public Sto update(Sto sto) {
		return stoRepository.save(sto);
	}

	@Override
	public Sto delete(Long id) {
		Optional<Sto> sto =	stoRepository.findById(id);
		if(sto.isPresent()) {
			stoRepository.deleteById(id);
			return sto.get();
		}
		return null;
	}

}
