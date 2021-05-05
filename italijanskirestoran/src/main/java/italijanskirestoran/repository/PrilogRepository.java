package italijanskirestoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import italijanskirestoran.model.Prilog;

@Repository
public interface PrilogRepository extends JpaRepository<Prilog, Long>{

	Prilog findOneById(Long id);
}
