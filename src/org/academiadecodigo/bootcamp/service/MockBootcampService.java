package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.BootCamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;

import java.util.*;

public class MockBootcampService implements BootcampService {

    private Map<Integer, BootCamp> bootCamps = new HashMap<>();

    @Override
    public void addBootCamp(BootCamp bootCamp){
        if (bootCamp == null){
            return;
        }
        if (findById(bootCamp.getId()) != null){
            // you can't add a bootcamp that already exists
            return;
        }
        bootCamps.put(bootCamp.getId(), bootCamp);
    }

    @Override
    public void addCodeCaddet(BootCamp bootCamp, CodeCadet codeCadet){
        if (codeCadet == null){
            return;
        }
        if (findById(bootCamp.getId()) == null){
            return;
        }
        // a code cadet can not be in more than one bootcamp
        if (codeCadet.getBootCamp() != null){
            codeCadet.getBootCamp().removeCadet(codeCadet);
        }

        codeCadet.setBootCamp(bootCamp);
        bootCamp.addCaddet(codeCadet);
    }



    @Override
    public BootCamp findById(int bootCampId) {
        return bootCamps.get(bootCampId);
    }

    @Override
    public List<CodeCadet> listAllCodeCadets(BootCamp bootCamp){
        return new LinkedList<>(bootCamp.getCadets());
    }

    @Override
    public List<BootCamp> listAllBootcamps(){
        return new LinkedList<>(bootCamps.values());
    }


}
