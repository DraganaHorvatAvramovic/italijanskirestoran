package italijanskirestoran.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import italijanskirestoran.model.Hrana;
import italijanskirestoran.repository.HranaRepository;
import italijanskirestoran.service.HranaService;

@Service
public class JpaHranaService implements HranaService {

	@Autowired
	private HranaRepository hranaRepository;
	@Override
	public Hrana findOne(Long id) {
		return hranaRepository.findOneById(id);
	}

	@Override
	public List<Hrana> findAll() {
		return hranaRepository.findAll();
	}

	@Override
	public Hrana save(Hrana hrana) {
		return hranaRepository.save(hrana);
	}

	@Override
	public Hrana update(Hrana hrana) {
		return hranaRepository.save(hrana);
	}

	@Override
	public Hrana delete(Long id) {
		Optional<Hrana> hrana = hranaRepository.findById(id);
		if(hrana.isPresent()) {
			hranaRepository.deleteById(id);
			return hrana.get();
		}
		return null;
	}

}
