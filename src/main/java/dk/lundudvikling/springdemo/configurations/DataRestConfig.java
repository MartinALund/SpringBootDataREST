package dk.lundudvikling.springdemo.configurations;

import dk.lundudvikling.springdemo.people.models.Animal;
import dk.lundudvikling.springdemo.people.models.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry corsRegistry) {
        setExposure(config, Person.class, HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT);
        setExposure(config, Animal.class, HttpMethod.GET);
    }

    private void setExposure(RepositoryRestConfiguration config, Class<?> domainClass, HttpMethod... methodsToDisable){
        config.getExposureConfiguration()
                .forDomainType(domainClass)
                .withItemExposure(((metadata, httpMethods) ->
                        httpMethods.disable(methodsToDisable)))
                .withCollectionExposure((metadata, httpMethods) ->
                        httpMethods.disable(methodsToDisable));
    }
}