package jedisdemo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.redis.jedis.jedisdemo.model.Programmer;
import io.redis.jedis.jedisdemo.services.ProgrammerService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgrammerController {

  @Autowired
  private ProgrammerService service;

  @PostMapping("/programmer-string")
  public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    service.setProgrammerAsString(String.valueOf(programmer.getId()),
        mapper.writeValueAsString(programmer));
  }

  @GetMapping("/programmer-string/{id}")
  public String readString(@PathVariable String id) {
    return service.getProgrammerAsString(id);
  }

  @PostMapping("/programmers-list")
  public void addToProgrammerList(@RequestBody Programmer programmer){
    service.addProgrammersList(programmer);
  }

  @GetMapping("/programmers-list")
  public List<Programmer> getProgrammersListMembers(){
    return service.getProgrammerListMembers();
  }

  @GetMapping("/programmers-list/count")
  public Long getProgrammersListCount(){
    return service.getProgrammersListCount();
  }

  @PostMapping("/programmers-set")
  public void addToProgrammerSet(@RequestBody Programmer... programmer){
    service.addProgrammersSet(programmer);
  }

  @GetMapping("/programmers-set")
  public Set<Programmer> getProgrammersSetMembers(){
    return service.getProgrammesSetMembers();
  }

  @GetMapping("/programmers-set/member")
  public boolean isSetMember(@RequestBody Programmer programmer){
    return service.isSetMember(programmer);
  }

  @PostMapping("/programmers-hash")
  public void addToProgrammerHash(@RequestBody Programmer programmer){
    service.saveProgrammerHash(programmer);
  }

  @PutMapping("/programmers-hash")
  public void updateProgrammerHash(@RequestBody Programmer programmer){
    service.saveProgrammerHash(programmer);
  }

  @GetMapping("/programmers-hash")
  public Map<Integer,Programmer> findAllProgrammersHash(){
    return service.findAllProgrammerHash();
  }

  @GetMapping("/programmers-hash/{id}")
  public Programmer findProgrammerHash(@PathVariable int id){
    return service.findProgrammerInHash(id);
  }

  @DeleteMapping("/programmers-hash/{id}")
  public void deleteProgrammerFromHash(@PathVariable int id){
   service.deleteProgrammerHash(id);
  }

}
