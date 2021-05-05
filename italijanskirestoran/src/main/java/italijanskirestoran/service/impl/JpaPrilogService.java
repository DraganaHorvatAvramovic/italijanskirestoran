package italijanskirestoran.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import italijanskirestoran.model.Prilog;
import italijanskirestoran.repository.PrilogRepository;
import italijanskirestoran.service.PrilogService;

@Service
public class JpaPrilogService implements PrilogService{

	@Autowired
	private PrilogRepository prilogRepository;
	
	@Override
	public Prilog findOne(Long id) {
		return prilogRepository.findOneById(id);
	}

	@Override
	public List<Prilog> findAll() {
		return prilogRepository.findAll();
	}

	@Override
	public Prilog save(Prilog prilog) {
		return prilogRepository.save(prilog);
	}

	@Override
	public Prilog update(Prilog prilog) {
		return prilogRepository.save(prilog);
	}

	@Override
	public Prilog delete(Long id) {
		Optional<Prilog> prilog = prilogRepository.findById(id);
		if(prilog.isPresent()) {
			prilogRepository.deleteById(id);
			return prilog.get();
		}
		return null;
	}

}
