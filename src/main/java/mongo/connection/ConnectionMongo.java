package mongo.connection;

public interface ConnectionMongo {
    String getHostName();

    int getPort();

    String getUsername();

    String getPassword();

    String getDatabase();

    boolean getSslSettings();

}
