package by.nikita.candies.builder;

import by.nikita.candies.exception.CandyErrorHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxCandyBuilder extends AbstractCandyBuilder {
    private static final Logger logger = LogManager.getLogger();
    private XMLReader reader;
    private SAXParserFactory factory = SAXParserFactory.newInstance();
    private SAXParser saxParser;

    @Override
    public void buildCandies(String fileName) {
        File file = new File(fileName);
        try {
            saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            CandyHandler handler = new CandyHandler();
            reader.setContentHandler(handler);
            reader.setErrorHandler(new CandyErrorHandler());
            reader.parse(String.valueOf(file));
            candySet = handler.getCandies();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}