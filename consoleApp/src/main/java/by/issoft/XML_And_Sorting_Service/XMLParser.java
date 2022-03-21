package by.issoft.XML_And_Sorting_Service;


import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


public class XMLParser {
    private Map <File, Document> parsedDocuments = new HashMap<>();
    private Document XMLToParse;
    public XMLParser(String path) throws InvalidPathException, NullPointerException,
            IOException, ParserConfigurationException, SAXException {
        File XMLFile;
        try {
            Paths.get(path);
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            //XMLFile = new File(classLoader.getResource("config/config.xml").getFile()); NPE
            XMLFile = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
            if (!XMLFile.exists() | !XMLFile.isFile()) throw new FileNotFoundException();
        } catch (InvalidPathException | NullPointerException | FileNotFoundException ex) {
            System.out.println("Config path is not valid: " + path);
            throw ex;
        }
        if (parsedDocuments.containsKey(XMLFile)){
            XMLToParse = parsedDocuments.get(XMLFile);
        }
        else {
            XMLToParse = DocumentBuilderFactory.newInstance().
                    newDocumentBuilder().
                    parse(XMLFile);
            parsedDocuments.put(XMLFile, XMLToParse);
        }
    }

    public LinkedHashMap<FieldTypes,SortingTypes> parseLatestConfig() {
        Map<FieldTypes, SortingTypes> sortingOrders = new LinkedHashMap<FieldTypes,SortingTypes>();
        Element rootElement = XMLToParse.getDocumentElement();
        NodeList fieldsToSort = rootElement.getChildNodes();
        for (int i = 0; i < fieldsToSort.getLength(); i++) {
            Node field = fieldsToSort.item(i);
            if (field.getNodeType() == Node.ELEMENT_NODE) {
                sortingOrders.put(parseFieldType(field.getNodeName()), parseSortingType(field.getTextContent()));
            }
        }
        sortingOrders.forEach((key, val)->{System.out.println(key + " " + val);});
        return (LinkedHashMap<FieldTypes, SortingTypes>) sortingOrders;
    }

    private FieldTypes parseFieldType(String s){
        FieldTypes type;
        switch (s) {
            case "name" :{ type = FieldTypes.NAME; break;}
            case "price":{ type = FieldTypes.PRICE; break;}
            case "rate" :{ type = FieldTypes.RATE; break;}
            default :{ type = FieldTypes.NAME; break;}
        }
        return type;
    }

    private SortingTypes parseSortingType(String s){
        SortingTypes type;
        switch (s) {
            case "asc" :{ type = SortingTypes.ASC; break;}
            case "desc":{ type = SortingTypes.DESC; break;}
            default :{ type = SortingTypes.ASC; break;}
        }
        return type;
    }
}


