package OortCloud.config.autoConfig;

import OortCloud.config.MyAutoConfigurationPropertie;
import org.springframework.stereotype.Component;


@MyAutoConfigurationPropertie(prefix = "server")
public class ServerProperties {
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
