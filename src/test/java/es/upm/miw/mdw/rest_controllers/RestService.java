package es.upm.miw.mdw.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class RestService {

    @Autowired
    private Environment environment;

    @Value("${server.servlet.contextPath}")
    private String contextPath;

    private int port = 0;

    private int getPort() {
        if (this.port == 0) {
            this.port = Integer.parseInt(environment.getProperty("local.server.port"));
        }
        return this.port;
    }

    public <T> RestBuilder<T> restBuilder(RestBuilder<T> restBuilder) {
        restBuilder.port(this.getPort());
        restBuilder.path(contextPath);
        return restBuilder;
    }

    public RestBuilder<Object> restBuilder() {
        RestBuilder<Object> restBuilder = new RestBuilder<>(this.port);
        restBuilder.path(contextPath);
        return restBuilder;
    }
}
