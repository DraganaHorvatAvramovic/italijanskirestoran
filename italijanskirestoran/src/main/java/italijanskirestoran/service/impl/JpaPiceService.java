package italijanskirestoran.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import italijanskirestoran.model.Pice;
import italijanskirestoran.repository.PiceRepository;
import italijanskirestoran.service.PiceService;

@Service
public class JpaPiceService implements PiceService{

	@Autowired
	private PiceRepository piceRepository;
	
	@Override
	public Pice findOne(Long id) {
		return piceRepository.findOneById(id);
	}

	@Override
	public List<Pice> findAll() {
		return piceRepository.findAll();
	}

	@Override
	public Pice save(Pice pice) {
		return piceRepository.save(pice);
	}

	@Override
	public Pice update(Pice pice) {
		return piceRepository.save(pice);
	}

	@Override
	public Pice delete(Long id) {
		Optional<Pice> pice = piceRepository.findById(id);
		if(pice.isPresent()) {
			piceRepository.deleteById(id);
			return pice.get();
		}
		return null;
	}
	

}
