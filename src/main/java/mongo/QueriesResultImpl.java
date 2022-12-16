package mongo;

import com.mongodb.client.MongoDatabase;
import mongo.QueriesResult;
import org.bson.Document;

public class QueriesResultImpl implements QueriesResult {
    private static MongoDatabase mongoDatabase;

    public QueriesResultImpl(MongoDatabase mongoDatabase) {

        this.mongoDatabase = mongoDatabase;
    }
}
