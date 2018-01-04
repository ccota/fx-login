package org.academiadecodigo.bootcamp.model;

import java.util.List;

public interface BootcampService {
    void addBootCamp(BootCamp bootCamp);

    void addCodeCaddet(BootCamp bootCamp, CodeCadet codeCadet);

    BootCamp findById(int bootCampId);

    List<CodeCadet> listAllCodeCadets(BootCamp bootCamp);

    List<BootCamp> listAllBootcamps();
}
