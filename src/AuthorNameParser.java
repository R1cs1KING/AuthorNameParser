import model.ParsedName;

public class AuthorNameParser {

    ParsedName parsedName;

    AuthorNameParser() {
        parsedName = new ParsedName();
    }

    public ParsedName parseName(String nameToParse) {
        if (isInputNameToParseConsistsValidCharacters(nameToParse)) {

        }

        return parsedName;
    }

    private boolean isInputNameToParseConsistsValidCharacters(String nameToParse) {
        // regex accepts latin characters
        // and the following special characters: .; '; - and space
        // it can contain maximum one: ,
        if (nameToParse.matches("[\\p{IsLatin}.'\\-\\s]*,?[\\p{IsLatin}.'\\-\\s]*")) {
            return true;
        }
        // TODO: error message to user
        System.out.println("The inserted name contains invalid characters");
        return false;
    }

    private boolean hasNameToParseComma(String nameToParse) {


        return false;
    }
}
