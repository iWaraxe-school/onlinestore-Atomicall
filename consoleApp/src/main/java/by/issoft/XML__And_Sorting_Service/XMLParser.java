package by.issoft.XML__And_Sorting_Service;

import by.issoft.XML__And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML__And_Sorting_Service.Enums.SortingTypes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;


public class XMLParser {
    private Document targetConfigXML;
    private Map<FieldTypes, SortingTypes> sortOrders = new LinkedHashMap<FieldTypes,SortingTypes>();

    public XMLParser(String path) throws InvalidPathException, NullPointerException,
            IOException, ParserConfigurationException, SAXException {
        File configFile;
        try {
            Paths.get(path);
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            //configFile = new File(classLoader.getResource("config/config.xml").getFile()); NPE
            configFile = new File(classLoader.getResource(path).getFile());
            if (!configFile.exists() | !configFile.isFile()) throw new FileNotFoundException();
        } catch (InvalidPathException | NullPointerException | FileNotFoundException ex) {
            System.out.println("Config path is not valid: " + path);
            throw ex;
        }
        targetConfigXML = DocumentBuilderFactory.newInstance().
                newDocumentBuilder().
                parse(configFile);
    }

    public void parseConfig() {
        Element rootElement = targetConfigXML.getDocumentElement();
        NodeList fieldsToSort = rootElement.getChildNodes();
        for (int i = 0; i < fieldsToSort.getLength(); i++) {
            Node field = fieldsToSort.item(i);
            if (field.getNodeType() == Node.ELEMENT_NODE) {
                sortOrders.put(parseFieldType(field.getNodeName()), parseSortingType(field.getTextContent()));
            }
        }
        sortOrders.forEach((key, val)->{System.out.println(key + " " + val);});
    }

    private FieldTypes parseFieldType(String s){
        FieldTypes type =
                switch (s){
                    case "name" -> FieldTypes.NAME;
                    case "price" -> FieldTypes.PRICE;
                    case "rate" -> FieldTypes.RATE;
                    default -> FieldTypes.NAME; //
        };
        return type;
    }
    private SortingTypes parseSortingType(String s){
        SortingTypes type =
                switch (s){
                    case "asc" -> SortingTypes.ASC;
                    case "desc" -> SortingTypes.DESC;
                    default -> SortingTypes.ASC;
                };
        return type;
    }
}


