package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;
    private JobClient jobServiceClient;

    public List<Job> getAllJobs() {
        return jobServiceClient.getAllJobs();
    }

    public Job getJobById(int id) {
        return jobServiceClient.getJobById(id);
    }

    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }
    public Optional<Candidat> findById(int id) {
        return candidatRepository.findById(id);
    }


    public Candidat save(Candidat candidat) {
        return candidatRepository.save(candidat);
    }


    public void deleteById(int id) {
        candidatRepository.deleteById(id);
    }

}
