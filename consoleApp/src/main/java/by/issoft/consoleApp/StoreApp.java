package by.issoft.consoleApp;
import by.issoft.store.Store;
import by.issoft.XML_And_Sorting_Service.XMLParser;
import by.issoft.store.http_sever.server.HTTPServerWrapper;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class StoreApp {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, IOException, ParserConfigurationException, SAXException, URISyntaxException {
        Store store = Store.getInstance();
        store.init();
        //StoreDB.getStoreDB().initTables();

        //store.populateCategories(StoreDB.getStoreDB());

        UserInteractService.printStore(store);
        XMLParser p = new XMLParser("config.xml");
        HTTPServerWrapper.getInstance().startServer();
        UserInteractService.readUserCommands(store, p.parseLatestConfig());
    }
}
