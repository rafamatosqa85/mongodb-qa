package mongo.connection;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.Collections;

public class MongoConfig {
    public static MongoDatabase create(final ConnectionMongo connectionMongo) {
        MongoCredential cred = MongoCredential.createCredential(connectionMongo.getUsername(), connectionMongo.getDatabase(),
                connectionMongo.getPassword().toCharArray());

        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(cred)
                .applyToSslSettings(builder ->
                        builder.enabled(connectionMongo.getSslSettings()))
                .applyToClusterSettings(builder ->
                        builder.hosts(Collections.singletonList(new ServerAddress(connectionMongo.getHostName(),
                                connectionMongo.getPort()
                        ))))
                .build();

        MongoClient mongoClient = MongoClients.create(settings);

        return mongoClient.getDatabase(connectionMongo.getDatabase());

    }
}
