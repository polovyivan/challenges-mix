package jedisdemo.services;

import io.redis.jedis.jedisdemo.model.Programmer;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerService {

  void setProgrammerAsString(String idKey, String programmer);

  String getProgrammerAsString(String key);

  //list
  void addProgrammersList(Programmer programmer);

  List<Programmer> getProgrammerListMembers();

  Long getProgrammersListCount();

  void addProgrammersSet(Programmer... programmers);

  Set<Programmer> getProgrammesSetMembers();

  boolean isSetMember(Programmer programmer);

  void saveProgrammerHash(Programmer programmer);

  void updateProgrammerHash(Programmer programmer);

  Map<Integer, Programmer> findAllProgrammerHash();

  Programmer findProgrammerInHash(int id);

  void deleteProgrammerHash(int id);

}
