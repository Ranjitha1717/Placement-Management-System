package placementmanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
	
	
	
    // Custom queries can go here if needed
	
	
	College save(College college);

	Optional<College> findById(Long id);

	List<College> findAll();

	void delete(College college);

	
} 




