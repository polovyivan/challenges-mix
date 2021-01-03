package jedisdemo.services;

import io.redis.jedis.jedisdemo.dao.ProgrammerRepository;
import io.redis.jedis.jedisdemo.model.Programmer;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

  @Autowired
  private ProgrammerRepository repository;


  @Override
  public void setProgrammerAsString(String idKey, String programmer) {
    repository.setProgrammerAsString(idKey, programmer);
  }

  @Override
  public String getProgrammerAsString(String key) {
    return repository.getProgrammerAsString(key);
  }

  @Override
  public void addProgrammersList(Programmer programmer) {
    repository.addToProgrammerList(programmer);
  }

  @Override
  public List<Programmer> getProgrammerListMembers() {
    return repository.getProgrammersListMembers();
  }

  @Override
  public Long getProgrammersListCount() {
    return repository.getProgrammersListCount();
  }

  @Override
  public void addProgrammersSet(Programmer... programmers) {
    repository.addToProgrammersSet(programmers);
  }

  @Override
  public Set<Programmer> getProgrammesSetMembers() {
    return repository.getProgrammersSetMembers();
  }

  @Override
  public boolean isSetMember(Programmer programmer) {
    return repository.isSetMember(programmer);
  }

  @Override
  public void saveProgrammerHash(Programmer programmer) {
    repository.saveHash(programmer);
  }

  @Override
  public void updateProgrammerHash(Programmer programmer) {
    repository.saveHash(programmer);
  }

  @Override
  public Map<Integer, Programmer> findAllProgrammerHash() {
    return repository.findAllHash();
  }

  @Override
  public Programmer findProgrammerInHash(int id) {
    return repository.findInHash(id);
  }

  @Override
  public void deleteProgrammerHash(int id) {
    repository.deleteHash(id);
  }
}
