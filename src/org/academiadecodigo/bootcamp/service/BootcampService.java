package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.BootCamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;

import java.util.List;

public interface BootcampService extends  Service{
    void addBootCamp(BootCamp bootCamp);

    void addCodeCaddet(BootCamp bootCamp, CodeCadet codeCadet);

    BootCamp findById(int bootCampId);

    List<CodeCadet> listAllCodeCadets(BootCamp bootCamp);

    List<BootCamp> listAllBootcamps();

    void setSelectedBootcamp(BootCamp bootCamp);

    BootCamp getSelectedBootcamp();
}
