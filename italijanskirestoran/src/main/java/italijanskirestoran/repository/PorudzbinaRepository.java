package italijanskirestoran.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import italijanskirestoran.model.Porudzbina;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {

	Porudzbina findOneById(Long id);
	
	@Query("SELECT p FROM Porudzbina p WHERE "
    		+ "(:stoId IS NULL OR p.sto.id =:stoId)" )
    Page<Porudzbina> pretraga(@Param("stoId") Long stoId, Pageable pageable);
}
