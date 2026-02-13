package tn.esprit.spring.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Journals")
public class JournalRestAPI {
    @Autowired
    private JournalService journalService;

    @PostMapping("/add")
    public void addJournal(@RequestBody Journal journal) {
        journalService.addJournal(journal);
    }
    @PutMapping("/update")
    public void updateJournal(@RequestBody Journal journal) {
        journalService.updateJournal(journal);
    }
    @GetMapping
    public List<Journal> getAllJournals() {
        return journalService.getAllJournals();
    }
    @DeleteMapping
    public void deleteJournal(@RequestBody Journal journal) {
        journalService.deleteJournal(journal);
    }
}
