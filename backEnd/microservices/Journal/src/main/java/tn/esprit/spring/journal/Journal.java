package tn.esprit.spring.journal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Journal {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;
    private Date created_at;
    private Date updated_at;
}
