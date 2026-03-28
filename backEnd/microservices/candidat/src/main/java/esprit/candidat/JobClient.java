package esprit.candidat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "job-service", url = "http://localhost:8082")
public interface JobClient {
    @RequestMapping("jobs")
    public List<Job> getAllJobs();

    @RequestMapping("jobs/{id}")
    public Job getJobById(@PathVariable int id);
}
