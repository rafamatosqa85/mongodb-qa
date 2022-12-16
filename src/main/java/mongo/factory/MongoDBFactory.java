package mongo.factory;

import mongo.connection.ConnectionMongo;
import mongo.utils.MongoCreator;
import mongo.utils.MongoUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MongoDBFactory {

    private static final Map<ConnectionMongo, MongoUtils> dbMap = new HashMap<>();

    private MongoDBFactory() {

    }

    public static MongoUtils get(ConnectionMongo conn) {
        Optional<MongoUtils> dbUtilsOptional = getFromConnection(conn);
        if (dbUtilsOptional.isPresent()) {
            return dbUtilsOptional.get();
        } else {
            MongoUtils mongoDbUtils = MongoCreator.create(conn);
            dbMap.put(conn, mongoDbUtils);
            return mongoDbUtils;
        }
    }

    private static Optional<MongoUtils> getFromConnection(ConnectionMongo conn) {
        MongoUtils dbUtilsFound = dbMap.get(conn);
        if (dbUtilsFound != null) {
            return Optional.of(dbUtilsFound);
        } else {
            return Optional.empty();
        }
    }
}
