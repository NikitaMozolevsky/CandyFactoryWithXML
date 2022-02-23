package by.nikita.candies.validator;

import by.nikita.candies.exception.CandyErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    public boolean saxValidator(String fileName, String schemaName) {
        boolean validate = false;
        String logName = "logs/log.txt";
        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
// установка проверки с использованием XSD
            schema = factory.newSchema(new File(schemaName));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
// создание объекта-парсера
            SAXParser parser = spf.newSAXParser();
// установка обработчика ошибок и запуск
            parser.parse(fileName, new CandyErrorHandler(logName));
            validate = true;
            System.out.println(fileName + " is valid");
        } catch (ParserConfigurationException e) {
            System.err.println(fileName + " config error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println(fileName + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
        return validate;
    }
}
