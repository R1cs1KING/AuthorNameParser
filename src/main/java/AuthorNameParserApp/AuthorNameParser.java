package AuthorNameParserApp;

import AuthorNameParserApp.model.ParsedName;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthorNameParser {

    ParsedName parsedName;

    public AuthorNameParser() {
        parsedName = new ParsedName();
    }

    public Optional<ParsedName> parseName(String nameToParse) {
        if (nameToParse == null || nameToParse.isEmpty()) {
            return Optional.empty();
        }

        if (isInputNameToParseConsistsValidCharacters(nameToParse)) {
            if (nameToParse.contains(",")) {
                splitNameToParseOnComma(nameToParse);
            } else  {
                // regex to find part of name where whitespace is followed by lowercase characters
                if (nameToParse.matches(".*\\s[a-z].*")) {
                    splitNameToParseOnFirstLowercaseAfterWhiteSpace(nameToParse);
                } else {
                    splitNameToParseOnLastSpace(nameToParse);
                }
            }
        } else {
            return Optional.empty();
        }

        return Optional.of(parsedName);
    }

    private boolean isInputNameToParseConsistsValidCharacters(String nameToParse) {
        // regex accepts latin characters
        // and the following special characters: .; '; - and space
        // it can contain maximum one: ,
        return nameToParse.matches("[\\p{IsLatin}.'\\-\\s]*,?[\\p{IsLatin}.'\\-\\s]*");
    }

    private void splitNameToParseOnComma(String nameToParse) {
        String lastName = nameToParse.substring(0, nameToParse.indexOf(","));
        String firstName = nameToParse.substring(nameToParse.indexOf(",") + 1).trim();

        setParsedName(firstName, lastName);
    }

    private void splitNameToParseOnLastSpace(String nameToParse) {
        String lastName = nameToParse.substring(nameToParse.lastIndexOf(" ") + 1).trim();
        String firstName = nameToParse.substring(0, nameToParse.lastIndexOf(" "));

        setParsedName(firstName, lastName);
    }

    private void splitNameToParseOnFirstLowercaseAfterWhiteSpace(String nameToParse) {
        int indexOfFirstLowercaseFollowingWhitespace = indexOfFirstPatternOccurrence("\\s[a-z]", nameToParse);

        String lastName = nameToParse.substring(indexOfFirstLowercaseFollowingWhitespace).trim();
        String firstName = nameToParse.substring(0, indexOfFirstLowercaseFollowingWhitespace);

        setParsedName(firstName, lastName);
    }

    private int indexOfFirstPatternOccurrence(String regexPattern, String string) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            return matcher.start();
        }

        return -1;
    }

    private void setParsedName(String firstName, String lastName) {
        parsedName.setLastName(lastName);
        parsedName.setFirstName(firstName);
    }
}
