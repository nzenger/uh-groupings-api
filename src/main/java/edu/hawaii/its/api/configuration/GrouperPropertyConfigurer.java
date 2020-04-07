package edu.hawaii.its.api.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import edu.internet2.middleware.grouperClient.util.GrouperClientConfig;

@Configuration
@EnableConfigurationProperties(GroupingsAPIConfig.class)
public class GrouperPropertyConfigurer {

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        GrouperClientConfig config = GrouperClientConfig.retrieveConfig();

        setOverride(config, "grouperClient.webService.url");
        setOverride(config, "grouperClient.webService.login");
        setOverride(config, "grouperClient.webService.password");
    }

    private void setOverride(GrouperClientConfig config, String key) {
        if (isOverride(key)) {
            config.propertiesOverrideMap().put(key, env.getProperty(key));
        }
    }

    // Checks to see if override exists
    private boolean isOverride(String key) {
        return env.containsProperty(key);
    }
}
