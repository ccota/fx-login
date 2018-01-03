package org.academiadecodigo.bootcamp.model;

import java.util.HashMap;
import java.util.Map;

public class MockBootcampService {

    private Map<Integer, BootCamp> bootCamps = new HashMap<>();

    public void createBootCamp(){
        //-Complete this
    }

    public void addCodeCaddet(int bootCampId, CodeCadet codeCadet){
        if (codeCadet == null){
            return;
        }
        findById(bootCampId).addCaddet(codeCadet);
    }

    public void addBootCamp(BootCamp bootCamp){
        bootCamps.put(bootCamp.getId(), bootCamp);
    }

    public BootCamp findById(int bootCampId) {
        return bootCamps.get(bootCampId);
    }


}
