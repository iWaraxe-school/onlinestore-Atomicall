package by.issoft.XML_And_Sorting_Service;

import by.issoft.XML_And_Sorting_Service.Enums.FieldTypes;
import by.issoft.XML_And_Sorting_Service.Enums.SortingTypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class XMLParserTest {
    String testPath = "config.xml";

    //неправильно грузит из папки тест
    @Test
    void testSucces() throws ParserConfigurationException, SAXException, IOException {
        XMLParser parser = Mockito.spy(new XMLParser(testPath));
        Map<FieldTypes, SortingTypes> result = new LinkedHashMap<>();
        result.put(FieldTypes.NAME, SortingTypes.DESC);
        result.put(FieldTypes.RATE, SortingTypes.DESC);
        result.put(FieldTypes.PRICE, SortingTypes.DESC);
        Assert.assertEquals(parser.parseLatestConfig(), result);
    }
}