module store {
    requires domain;
    requires javafaker;
    requires org.reflections;
    requires java.sql;

    exports by.issoft.store;
    exports by.issoft.store.database;
    exports by.issoft.store.database.repository;
}