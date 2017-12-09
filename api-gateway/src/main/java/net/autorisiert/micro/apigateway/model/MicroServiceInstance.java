package net.autorisiert.micro.apigateway.model;

import com.netflix.appinfo.InstanceInfo;

public class MicroServiceInstance {
   private InstanceInfo.InstanceStatus status;
   private String url;

    public InstanceInfo.InstanceStatus getStatus() {
        return status;
    }

    public void setStatus(InstanceInfo.InstanceStatus status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
