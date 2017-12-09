package net.autorisiert.micro.apigateway.controller;

import net.autorisiert.micro.apigateway.model.MicroService;
import net.autorisiert.micro.apigateway.model.MicroServiceInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/discovery")
public class DiscoveryController {
    private final DiscoveryClient discoveryClient;

    @Autowired
    public DiscoveryController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("/list")
    public List<MicroService> getDiscoveryClients() {
        List<MicroService> result = new ArrayList<>();
        discoveryClient.getServices().forEach(s -> {
            MicroService service = new MicroService();
            service.setName(s);
            List<MicroServiceInstance> list = new ArrayList<>();
            service.setInstances(list);
            discoveryClient.getInstances(s).stream()
                    .map(inst -> (EurekaDiscoveryClient.EurekaServiceInstance) inst)
                    .forEach(inst -> {
                        MicroServiceInstance instance = new MicroServiceInstance();
                        instance.setUrl(inst.getUri().toString());
                        instance.setStatus(inst.getInstanceInfo().getStatus());
                        list.add(instance);
                    });
            result.add(service);
        });
        return result;
    }
}
