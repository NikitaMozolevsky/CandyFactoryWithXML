package by.nikita.candies.builder;

import by.nikita.candies.entity.AbstractCandy;
import by.nikita.candies.entity.DomesticCandy;
import by.nikita.candies.entity.ImportedCandy;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.Year;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static by.nikita.candies.builder.CandyEnum.*;


public class CandyHandler extends DefaultHandler {
    private final Set<AbstractCandy> candies;
    private AbstractCandy candy = null;
    private CandyEnum candyEnum = null;
    private final EnumSet<CandyEnum> withText;

    public CandyHandler() {
        candies = new HashSet<>();
        withText = EnumSet.range(CandyEnum.NAME, CandyEnum.IMPORTED_CANDY_PROPERTIES);
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        String importedCandy = IMPORTED_CANDY.getValue();
        String domesticCandy = DOMESTIC_CANDY.getValue();
        if (importedCandy.equals(localName) || domesticCandy.equals(localName)) {
            candy = importedCandy.equals(localName) ? new ImportedCandy() : new DomesticCandy();
            candy.setCandyId(attrs.getValue(CANDY_ID.getValue()));
            String optionalTitle = attrs.getValue(TITLE.getValue());
            candy.setTitle(optionalTitle == null ? TITLE_BY_DEFAULT.getValue() : optionalTitle);
        } else {
            CandyEnum temp = CandyEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                candyEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        String importedCandy = IMPORTED_CANDY.getValue();
        String domesticCandy = DOMESTIC_CANDY.getValue();
        if (importedCandy.equals(localName) || domesticCandy.equals(localName)) {
            candies.add(candy);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();
        if (candyEnum != null) {
            switch (candyEnum) {
                case NAME -> candy.setCandyName(data);
                case YEAR -> candy.setCandyYear(Year.parse(data));
                case ENERGY -> candy.setCandyEnergy(Integer.parseInt(data));
                case TYPE -> candy.setCandyType(data);
                case WATER -> candy.getCandyIngredients().setWater(Integer.parseInt(data));
                case SUGAR -> candy.getCandyIngredients().setSugar(Integer.parseInt(data));
                case VANILLA -> candy.getCandyIngredients().setVanilla(Integer.parseInt(data));
                case CHOCOLATE_TYPE -> candy.getCandyIngredients().setChocolateType(data);
                case FRUCTOSE -> candy.getCandyIngredients().setFructose(Integer.parseInt(data));
                case PROTEIN -> candy.getCandyValue().setProtein(Integer.parseInt(data));
                case FAT -> candy.getCandyValue().setFat(Integer.parseInt(data));
                case CARBOHYDRATE -> candy.getCandyValue().setCarbohydrate(Integer.parseInt(data));
                case PRODUCTION -> candy.setCandyProduction(data);
                case IMPORTED_CANDY_PROPERTIES -> {
                    ImportedCandy importedCandy = (ImportedCandy) candy;
                    importedCandy.setImportedCandyProperties(data);
                }
                case DOMESTIC_CANDY_PROPERTIES -> {
                    DomesticCandy domesticCandy = (DomesticCandy) candy;
                    domesticCandy.setDomesticCandyProperties(data);
                }
            }
        }
    }

    public Set<AbstractCandy> getCandies() {
        return candies;
    }

}
