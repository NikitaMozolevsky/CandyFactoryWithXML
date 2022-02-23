package by.nikita.candies.builder;

import by.nikita.candies.entity.AbstractCandy;
import by.nikita.candies.entity.DomesticCandy;
import by.nikita.candies.entity.ImportedCandy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import static by.nikita.candies.builder.AbstractCandyBuilder.*;

public class DomCandyBuilder extends AbstractCandyBuilder {
    private static final Logger logger = LogManager.getLogger();
    private final Set<AbstractCandy> candies = new HashSet<>();
    private DocumentBuilderFactory factory;
    private DocumentBuilder documentBuilder;

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

    public void buildCandies(String fileName) {
        File file = new File(fileName);
        try {
            factory = DocumentBuilderFactory.newInstance();
            documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            NodeList candyList = document.getElementsByTagName(IMPORTED_CANDY);
            for (int i = 0; i < candyList.getLength(); i++) {
                Node node = candyList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element candyElement = (Element) node;
                    AbstractCandy candy = DomBuildCandy(candyElement);
                    candies.add(candy);
                }
            }

            candyList = document.getElementsByTagName(DOMESTIC_CANDY);
            for (int i = 0; i < candyList.getLength(); i++) {
                Node node = candyList.item(i);
                Element candyElement = (Element) node;
                AbstractCandy candy = DomBuildCandy(candyElement);
                candies.add(candy);
            }

            //TODO if correct catch
        } catch (SAXException exception) {
            logger.log(Level.ERROR, "File was not parsed!", exception);
        } catch (IOException exception) {
            logger.log(Level.ERROR, "File was not read!", exception);
        } catch (ParserConfigurationException exception) {
            logger.log(Level.ERROR, "File was not parsed!", exception);
            exception.printStackTrace();
        }
    }

    public AbstractCandy DomBuildCandy(Element element) {
        AbstractCandy candy = element.getTagName().equals(IMPORTED_CANDY) ?
                new ImportedCandy() : new DomesticCandy();
        String data = element.getAttribute(CANDY_ID);
        candy.setCandyId(data);
        data = getElementTextContent(element, NAME);
        candy.setCandyName(data);
        data = getElementTextContent(element, YEAR);
        candy.setCandyYear(Year.parse(data));
        data = getElementTextContent(element, ENERGY);
        candy.setCandyEnergy(Integer.parseInt(data));
        data = getElementTextContent(element, TYPE);
        candy.setCandyType(data);
        data = getElementTextContent(element, WATER);
        candy.getCandyIngredients().setWater(Integer.parseInt(data));
        data = getElementTextContent(element, SUGAR);
        candy.getCandyIngredients().setSugar(Integer.parseInt(data));
        data = getElementTextContent(element, FRUCTOSE);
        candy.getCandyIngredients().setFructose(Integer.parseInt(data));
        data = getElementTextContent(element, CHOCOLATE_TYPE);
        candy.getCandyIngredients().setChocolateType(data);
        data = getElementTextContent(element, VANILLA);
        candy.getCandyIngredients().setVanilla(Integer.parseInt(data));
        data = getElementTextContent(element, PROTEIN);
        candy.getCandyValue().setProtein(Double.parseDouble(data));
        data = getElementTextContent(element, FAT);
        candy.getCandyValue().setFat(Double.parseDouble(data));
        data = getElementTextContent(element, CARBOHYDRATE);
        candy.getCandyValue().setCarbohydrate(Double.parseDouble(data));
        data = getElementTextContent(element, PRODUCTION);
        candy.setCandyProduction(data);

        if (candy instanceof ImportedCandy importedCandy) {
            data = getElementTextContent(element, IMPORTED_CANDY_PROPERTIES);
            importedCandy.setImportedCandyProperties(data);
        } else {
            data = getElementTextContent(element, DOMESTIC_CANDY_PROPERTIES);
            DomesticCandy domesticCandy = (DomesticCandy) candy;
            domesticCandy.setDomesticCandyProperties(data);
        }
        return candy;
    }
}
