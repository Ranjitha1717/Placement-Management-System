package placementmanagement;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;

    // Constructor Injection for repository
    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    // Create a new college
    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    // Get a college by ID
    public College getCollegeById(Long id) throws CollegeNotFoundException {
        return collegeRepository.findById(id)
                .orElseThrow(() -> new CollegeNotFoundException("College not found with ID: " + id));
    }

    // Get all colleges
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    // Update an existing college
    public College updateCollege(Long id, College college) throws CollegeNotFoundException {
        College existingCollege = getCollegeById(id);
        existingCollege.setName(college.getName());
        existingCollege.setLocation(college.getLocation());
        existingCollege.setAffiliation(college.getAffiliation());
        return collegeRepository.save(existingCollege);
    }

    // Delete a college by ID
    public void deleteCollege(Long id) throws CollegeNotFoundException {
        College college = getCollegeById(id);
        collegeRepository.delete(college);
    }
}
