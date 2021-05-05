package italijanskirestoran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import italijanskirestoran.model.Stavka;

@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Long> {

	Stavka findOneById(Long id);
	
	List<Stavka> findByPorudzbinaId(Long id);
	
	Stavka findByPorudzbinaIdAndHranaIdAndPrilogIdAndPiceId(Long porudzbinaId, Long hranaId, Long prilogId, Long piceId);
}
