package by.nikita.candies.factory;

import by.nikita.candies.builder.AbstractCandyBuilder;
import by.nikita.candies.builder.DomCandyBuilder;
import by.nikita.candies.builder.SaxCandyBuilder;
import by.nikita.candies.builder.StaxCandyBuilder;

public class CandyBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractCandyBuilder createStudentBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DomCandyBuilder();
            case STAX:
                return new StaxCandyBuilder();
            case SAX:
                return new SaxCandyBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
