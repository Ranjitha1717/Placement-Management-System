package placementmanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        try {
            College createdCollege = collegeService.createCollege(college);
            return new ResponseEntity<>(createdCollege, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        try {
            College college = collegeService.getCollegeById(id);
            return ResponseEntity.ok(college);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<College>> getAllColleges() {
        try {
            List<College> colleges = collegeService.getAllColleges();
            return ResponseEntity.ok(colleges);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College college) {
        try {
            College updatedCollege = collegeService.updateCollege(id, college);
            return ResponseEntity.ok(updatedCollege);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCollege(@PathVariable Long id) {
        try {
            collegeService.deleteCollege(id);
            return ResponseEntity.ok("College deleted successfully");
        } catch (Exception ex) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
