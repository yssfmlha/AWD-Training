package tn.esprit.spring.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired
    JournalRepository repo;

    public Journal addJournal(Journal journal) {
        return repo.save(journal);
    }
    public List<Journal> getAllJournals() {
        return repo.findAll();
    }
    public Journal updateJournal(Journal journal) {
        return repo.save(journal);
    }
    public void deleteJournal(Journal journal) {
        repo.delete(journal);
    }
}
