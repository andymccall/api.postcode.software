package software.postcode.api.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import software.postcode.api.Application;

@Configuration
@PropertySource("classpath:application.properties")
@EnableMongoRepositories
@ComponentScan(basePackageClasses = {Application.class})
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongodb.host}")
    String mongodb_host;

    @Value("${mongodb.port}")
    int mongodb_port;

    @Value("${mongodb.databasename}")
    String mongodb_databasename;

    @Override
    protected String getDatabaseName() {
        return mongodb_databasename;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient( mongodb_host, mongodb_port );
    }

    @Override
    protected String getMappingBasePackage() {
        return "software.postcode.api.pafdatabase";
    }
}