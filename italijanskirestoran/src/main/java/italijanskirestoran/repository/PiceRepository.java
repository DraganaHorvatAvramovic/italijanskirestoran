package italijanskirestoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import italijanskirestoran.model.Pice;

@Repository
public interface PiceRepository extends JpaRepository<Pice, Long>{

	Pice findOneById(Long id);
}
