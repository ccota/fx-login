package org.academiadecodigo.bootcamp.model;

import java.util.Date;

public interface BootcampService {

    void addCodeCaddet(int bootCampId, CodeCadet codeCadet);

    void addBootCamp(BootCamp bootCamp);

    BootCamp findById(int bootCampId);
}
