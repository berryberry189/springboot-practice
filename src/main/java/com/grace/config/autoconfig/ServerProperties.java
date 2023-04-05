package com.grace.config.autoconfig;

import com.grace.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {

    // server.contextPath
    private String contextPath;

    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
