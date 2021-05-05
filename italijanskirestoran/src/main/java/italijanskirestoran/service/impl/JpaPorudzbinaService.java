package italijanskirestoran.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import italijanskirestoran.model.Porudzbina;
import italijanskirestoran.repository.PorudzbinaRepository;
import italijanskirestoran.service.PorudzbinaService;

@Service
public class JpaPorudzbinaService implements PorudzbinaService {

	@Autowired
	private PorudzbinaRepository porudzbinaRepository;
	
	@Override
	public Porudzbina findOne(Long id) {
		return porudzbinaRepository.findOneById(id);
	}

	@Override
	public List<Porudzbina> findAll() {
		return porudzbinaRepository.findAll();
	}

	@Override
	public Porudzbina save(Porudzbina porudzbina) {
		return porudzbinaRepository.save(porudzbina);
	}

	@Override
	public Porudzbina update(Porudzbina porudzbina) {
		return porudzbinaRepository.save(porudzbina);
	}

	@Override
	public Porudzbina delete(Long id) {
		Optional<Porudzbina> porudzbina = porudzbinaRepository.findById(id);
		if(porudzbina.isPresent()) {
			porudzbinaRepository.deleteById(id);
			return porudzbina.get();
		}
		return null;
	}

	@Override
	public Page<Porudzbina> pretraga(Long stoId, int pageNo) {
		return porudzbinaRepository.pretraga(stoId, PageRequest.of(pageNo, 2));
	}

}
