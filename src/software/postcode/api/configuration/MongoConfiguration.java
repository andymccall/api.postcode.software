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

/**
 * The MongoConfiguration class is a class that implements the
 * AbstractMongoConfiguration and sets up all the configuration
 * needed to connect to the mongodb.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-01-29
 */
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

}