package mongo.utils;

import mongo.QueriesResultImpl;
import mongo.connection.ConnectionMongo;
import com.mongodb.client.MongoDatabase;
import mongo.connection.MongoConfig;

public class MongoCreator {
    public static MongoUtils create(ConnectionMongo conn) {
        MongoDatabase mongoDb = new MongoConfig().create(conn);
        QueriesResultImpl resultQuery = new QueriesResultImpl(mongoDb);
        return new MongoUtils(resultQuery);
    }
}
