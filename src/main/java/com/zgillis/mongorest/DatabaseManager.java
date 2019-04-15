package com.zgillis.mongorest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseManager {
    MongoClientURI clientURI;
    MongoClient client;
    MongoDatabase database;
    MongoCollection collection;

    public DatabaseManager(String connectionString, String databaseName, String collectionName) {
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
