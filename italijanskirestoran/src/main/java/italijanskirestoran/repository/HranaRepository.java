package italijanskirestoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import italijanskirestoran.model.Hrana;

@Repository
public interface HranaRepository extends JpaRepository<Hrana, Long>{

	Hrana findOneById(Long id);
}
