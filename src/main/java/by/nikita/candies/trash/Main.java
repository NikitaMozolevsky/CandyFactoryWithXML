package by.nikita.candies.trash;

import by.nikita.candies.entity.Explain;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Explain example = new Explain();
        example.string.equals("2");
        System.out.println(example.string.equals("2"));
        try {
// создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SimpleCandyHandler handler = new SimpleCandyHandler();
            reader.setContentHandler(handler);
            reader.parse("data/candies.xml");
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }
}
