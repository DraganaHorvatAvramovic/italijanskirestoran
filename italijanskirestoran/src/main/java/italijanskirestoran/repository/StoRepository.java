package italijanskirestoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import italijanskirestoran.model.Sto;

@Repository
public interface StoRepository extends JpaRepository<Sto, Long> {

	Sto findOneById(Long id);
}
