package by.issoft.consoleApp;
import by.issoft.store.Store;
import by.issoft.XML_And_Sorting_Service.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class StoreApp {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, IOException, ParserConfigurationException, SAXException, URISyntaxException {
        Store store = new Store();
        store.init();
        store.populateCategories();
        UserInteractService.printStore(store);
        XMLParser p = new XMLParser("config.xml");
        p.parseConfig();
        UserInteractService.readUserCommands(store);
    }
}
