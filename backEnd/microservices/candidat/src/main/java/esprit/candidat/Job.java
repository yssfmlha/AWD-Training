package esprit.candidat;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Job {
    private int id;
    private String service;
    private boolean etat;
}
