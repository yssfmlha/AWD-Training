package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mic1/candidats")
public class CandidatRESTApi {
    //simple web service for testing
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello I'm Microservice Candidat";
    }
    @Autowired
    private CandidatService candidatService;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Candidat>> listCandidat() {
        return ResponseEntity.ok(candidatService.findAll());
    }

    // =======================
    // READ BY ID
    // =======================
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> getCandidatById(@PathVariable int id) {
        return candidatService.findById(id)
                .map(candidat -> ResponseEntity.ok(candidat))
                .orElse(ResponseEntity.notFound().build());
    }

    // =======================
    // CREATE
    // =======================
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> addCandidat(@RequestBody Candidat candidat) {
        Candidat saved = candidatService.save(candidat);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // =======================
    // UPDATE
    // =======================
    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidat> updateCandidat(
            @PathVariable int id,
            @RequestBody Candidat candidat) {

        return candidatService.findById(id)
                .map(existing -> {
                    existing.setFirstName(candidat.getFirstName());
                    existing.setLastName(candidat.getLastName());
                    existing.setEmail(candidat.getEmail());
                    return ResponseEntity.ok(candidatService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // =======================
    // DELETE
    // =======================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable int id) {
        if (candidatService.findById(id).isPresent()) {
            candidatService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(candidatService.getAllJobs());
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id) {
        return ResponseEntity.ok(candidatService.getJobById(id));
    }
}
