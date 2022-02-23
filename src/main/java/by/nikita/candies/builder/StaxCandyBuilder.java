package by.nikita.candies.builder;

import by.nikita.candies.entity.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import static by.nikita.candies.builder.AbstractCandyBuilder.*;

public class StaxCandyBuilder extends AbstractCandyBuilder {

    private static final Logger logger = LogManager.getLogger();
    private HashSet<AbstractCandy> students = new HashSet<>();
    private XMLInputFactory inputFactory;

    public StaxCandyBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<AbstractCandy> getCandies() {
        return getCandies();
    }

    @Override
    public void buildCandies(String fileName) throws FileNotFoundException {

    }

    public void buildSetStudents(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(CandyEnum.IMPORTED_CANDY.getValue()) ||
                            name.equals(CandyEnum.DOMESTIC_CANDY.getValue())) {
                        AbstractCandy candy = buildCandies(reader);
                    }
                    /*if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.CANDIES) {
                        Student st = buildStudent(reader);
                        students.add(st);
                    }*/
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private AbstractCandy buildCandies(XMLStreamReader reader) throws XMLStreamException {
            AbstractCandy candy = reader.getLocalName().equals(CandyEnum.IMPORTED_CANDY) ?
                    new ImportedCandy() : new DomesticCandy();
            candy.setCandyId(reader.getAttributeValue(null, CandyEnum.CANDY_ID.getValue()));
            candy.setTitle(reader.getAttributeValue(null, CandyEnum.TITLE.getValue()));

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case NAME -> candy.setCandyName(getXMLText(reader));
                        case YEAR -> candy.setCandyYear(Year.parse(getXMLText(reader)));
                        case ENERGY -> candy.setCandyEnergy(Integer.parseInt(getXMLText(reader)));
                        case CHOCOLATE_TYPE -> candy.setCandyType(getXMLText(reader));
                        case VALUE -> getValuesFromXML(reader, candy.getCandyValue());
                        case INGREDIENTS -> getIngredientsFromXML(reader, candy.getCandyIngredients());
                        case PRODUCTION -> candy.setCandyProduction(getXMLText(reader));
                        case IMPORTED_CANDY_PROPERTIES -> {
                            ImportedCandy importedCandy = (ImportedCandy) candy;
                            importedCandy.setImportedCandyProperties(getXMLText(reader));
                        }
                        case DOMESTIC_CANDY_PROPERTIES -> {
                            DomesticCandy domesticCandy = (DomesticCandy) candy;
                            domesticCandy.setDomesticCandyProperties(getXMLText(reader));
                        }
                    }
                    /*case XMLStreamConstants.END_ELEMENT -> {
                        name = reader.getLocalName();
                        if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.DOMESTIC_CANDY ||
                                CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.IMPORTED_CANDY) {
                            return candy;
                        }
                        break;
                    }*/
            }

        }
           return candy;
    }

    private CandyValue getValuesFromXML(XMLStreamReader reader, CandyValue candyValue) throws XMLStreamException {
        while (reader.hasNext()) {
            int type = reader.next();
            String name = reader.getLocalName();
            String data = getXMLText(reader);
            switch (type) {
                case XMLStreamConstants.START_ELEMENT -> {
                    // TariffXmlTag currentTag = TariffXmlTag.valueOf(name.toUpperCase().replace(HYPHEN, UNDERSCORE));
                    switch (name) {
                        case PROTEIN -> candyValue.setProtein(Double.parseDouble(data));
                        case FAT -> candyValue.setFat(Double.parseDouble(data));
                        case CARBOHYDRATE -> candyValue.setCarbohydrate(Double.parseDouble(data));
                        default -> logger.log(Level.ERROR, "Unsupported tag: {}", name);
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.VALUE) {
                        return candyValue;
                    }
                    break;
                }
                default -> logger.log(Level.ERROR, "Unsupported tag: {}", name);
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private CandyIngredients getIngredientsFromXML(XMLStreamReader reader, CandyIngredients candyIngredients) throws XMLStreamException {
        while (reader.hasNext()) {
            int type = reader.next();
            String name = reader.getLocalName();
            String data = getXMLText(reader);
            switch (type) {
                case XMLStreamConstants.START_ELEMENT -> {
                    // TariffXmlTag currentTag = TariffXmlTag.valueOf(name.toUpperCase().replace(HYPHEN, UNDERSCORE));
                    switch (name) {
                        case WATER -> candyIngredients.setWater(Integer.parseInt(data));
                        case SUGAR -> candyIngredients.setSugar(Integer.parseInt(data));
                        case FRUCTOSE -> candyIngredients.setFructose(Integer.parseInt(data));
                        case CHOCOLATE_TYPE -> candyIngredients.setChocolateType(data);
                        case VANILLA -> candyIngredients.setVanilla(Integer.parseInt(data));
                        default -> logger.log(Level.ERROR, "Unsupported tag: {}", name);
                    }
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.VALUE) {
                        return candyIngredients;
                    }
                    break;
                }
                default -> logger.log(Level.ERROR, "Unsupported tag: {}", name);
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
