package by.issoft.consoleApp;
import by.issoft.store.Store;
import by.issoft.XML_And_Sorting_Service.XMLParser;
import by.issoft.store.http_client.HTTPClientWrapper;
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
        HTTPServerWrapper.getInstance().startServer();
        HTTPClientWrapper clientWrapper = new HTTPClientWrapper(8008);
        store.populateCategories(clientWrapper.requestDataFromDB());
        UserInteractService.printStore(store);
        XMLParser p = new XMLParser("config.xml");
        try {
            UserInteractService.readUserCommands(store, p.parseLatestConfig(), clientWrapper);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
