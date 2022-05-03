module store {
    requires domain;
    requires javafaker;
    requires org.reflections;
    requires java.sql;
    requires  jdk.httpserver;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires java.net.http;


    exports by.issoft.store;
    exports by.issoft.store.database;
    exports by.issoft.store.database.repository;
    exports by.issoft.store.http_sever.server;
    exports by.issoft.store.http_client;
}