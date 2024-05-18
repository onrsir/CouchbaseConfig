package com.cb.Couchbase.config;

import com.cb.Couchbase.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

import java.util.Collections;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Autowired
    private ApplicationContext context;

    @Override
    public String getConnectionString() {
       return "couchbase://127.0.0.1";
          }

    @Override
    public String getUserName() {
        return "rest";
    }

    @Override
    public String getPassword() {
        return "amklade41";
    }

    @Override
    public String getBucketName() {
        return "customer";
    }

    @Override
    public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {

        mapping.mapEntity(User.class,getCouchbaseTemplate("user"));
    }
    @SneakyThrows
    private CouchbaseTemplate getCouchbaseTemplate(String bucketName){
        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName),
        mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),new CouchbaseCustomConversions(Collections.emptyList())));

        template.setApplicationContext(context);
        return template;
    }

    private CouchbaseClientFactory couchbaseClientFactory(String bucketName){
        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()),bucketName,this.getScopeName());
    }

}

