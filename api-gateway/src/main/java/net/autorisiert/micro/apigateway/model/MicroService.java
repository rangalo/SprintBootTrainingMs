package net.autorisiert.micro.apigateway.model;

import java.util.List;

public class MicroService {
    private String name;
    private List<MicroServiceInstance> instances;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MicroServiceInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<MicroServiceInstance> instances) {
        this.instances = instances;
    }
}
