package com.zgillis.mongorest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseManager {

//    private static String connectionString = "mongodb+srv://zgillis:Laptopfoxes57@cluster0-tzs5y.gcp.mongodb.net/test?retryWrites=true";
    private static String databaseName = "z-stats";
    private static String collectionName = "btc_stats";
    MongoClientURI clientURI;
    MongoClient client;
    MongoDatabase database;
    MongoCollection collection;

    public DatabaseManager(String connectionString) {
        clientURI = new MongoClientURI(connectionString);
        client = new MongoClient(clientURI);
        database = client.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
    }

    public void storeDocument(DocumentField[] fields) {
        Document newDocument = new Document();

        for (int i = 0; i < fields.length; i++) {
            DocumentField field = fields[i];
            newDocument.append(field.getKey(), field.getValue());
        }

        collection.insertOne(newDocument);
    }

}
