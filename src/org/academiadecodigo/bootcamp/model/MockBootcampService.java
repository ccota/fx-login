package org.academiadecodigo.bootcamp.model;

import java.util.*;

public class MockBootcampService implements BootcampService {

    private Map<Integer, BootCamp> bootCamps = new HashMap<>();



    @Override
    public void addCodeCaddet(int bootCampId, CodeCadet codeCadet){
        if (codeCadet == null){
            return;
        }
        if (findById(bootCampId) == null){
            return;
        }
        // a code cadet can not be in more than one bootcamp
        for (BootCamp b:bootCamps.values()) {
            if ( b.getCadets().contains(codeCadet)){
                b.removeCadet(codeCadet);
            }
        }



        codeCadet.setBootCamp(findById(bootCampId));
        findById(bootCampId).addCaddet(codeCadet);
    }

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
    public BootCamp findById(int bootCampId) {
        return bootCamps.get(bootCampId);
    }

    public List<CodeCadet> listAllCodeCadets(BootCamp bootCamp){
        return new LinkedList<>(bootCamp.getCadets());
    }

    public List<BootCamp> listAllBootcamps(){
        return new LinkedList<>(bootCamps.values());
    }


}
