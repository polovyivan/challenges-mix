package jedisdemo.dao;

import jedisdemo.model.Programmer;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerRepository {

  void setProgrammerAsString(String idKey, String programmer);

  String getProgrammerAsString(String idKey);

  Long getProgrammersListCount();

  List<Programmer> getProgrammersListMembers();

  void addToProgrammerList(Programmer programmer);

  void addToProgrammersSet(Programmer... programmer);

  Set<Programmer> getProgrammersSetMembers();

  boolean isSetMember(Programmer programmer);

  void saveHash(Programmer programmer);

  void updateHash(Programmer programmer);

  Map<Integer, Programmer> findAllHash();

  Programmer findInHash(int id);

  void deleteHash(int id);

}
