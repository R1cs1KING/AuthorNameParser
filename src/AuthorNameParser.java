import model.ParsedName;

import javax.lang.model.element.Name;

public class AuthorNameParser {

    ParsedName parsedName;

    AuthorNameParser() {
        parsedName = new ParsedName();
    }

    public ParsedName parseName(String nameToParse) {
        if (isInputNameToParseConsistsValidCharacters(nameToParse)) {
            if (nameToParse.contains(",")) {
                splitNameToParseOnComma(nameToParse);
            } else  {
                System.out.println("It does not have a comma");
                // regex checks if the nameToParse has any other characters than latin letters
                if (nameToParse.matches("\\p{IsLatin}")) {
                    // TODO: implement cases when there is no special character included
                } else {
                    splitNameToParseOnLastSpace(nameToParse);
                }
            }
        } else {
            // TODO: return error message to user
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

    private void splitNameToParseOnComma(String nameToParse) {
        String lastName = nameToParse.substring(0, nameToParse.indexOf(","));
        String firstName = nameToParse.substring(nameToParse.indexOf(",") + 1).trim();

        parsedName.setLastName(lastName);
        parsedName.setFirstName(firstName);
    }

    private void splitNameToParseOnLastSpace(String nameToParse) {
        String lastName = nameToParse.substring(nameToParse.lastIndexOf(" ") + 1).trim();
        String firstName = nameToParse.substring(0, nameToParse.lastIndexOf(" "));

        parsedName.setLastName(lastName);
        parsedName.setFirstName(firstName);
    }
}
