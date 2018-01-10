package org.academiadecodigo.bootcamp.service;


import java.util.HashMap;
import java.util.Map;

public final class ServiceRegistry {


    private Map<String, Service> serviceContainer = new HashMap<>();

    private static ServiceRegistry instance = null;

    private ServiceRegistry(){

    }



    public  Service getService (String serviceName){
        return serviceContainer.get(serviceName);
    }
    // static method that returns the instance
    public static synchronized ServiceRegistry getInstance() {

        // the instance is created only the first time this method is called
        if(instance == null) {
            instance = new ServiceRegistry();
        }

        // it always returns the same instance, there is no way to have another one
        return instance;
    }

    public synchronized void addService(String serviceName, Service service){
        serviceContainer.put(serviceName, service);
    }

}
