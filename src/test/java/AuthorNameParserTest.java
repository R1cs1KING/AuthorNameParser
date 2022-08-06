import AuthorNameParserApp.AuthorNameParser;
import AuthorNameParserApp.model.ParsedName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthorNameParserTest {

    @Test
    public void testParseTwoPartName() {
        String nameToParse = "Rahul Kumar";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("Rahul", parsedName.getFirstName());
        Assertions.assertEquals("Kumar", parsedName.getLastName());
    }

    @Test
    public void testParseThreePartName() {
        String nameToParse = "CH Ravindra Reddy";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("CH Ravindra", parsedName.getFirstName());
        Assertions.assertEquals("Reddy", parsedName.getLastName());
    }

    @Test
    public void testParseThreePartNameWithComma() {
        String nameToParse = "Reddy, CH Ravindra";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("CH Ravindra", parsedName.getFirstName());
        Assertions.assertEquals("Reddy", parsedName.getLastName());
    }

    @Test
    public void testParseTwoPartNameWithComma() {
        String nameToParse = "Raju, Banothu";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("Banothu", parsedName.getFirstName());
        Assertions.assertEquals("Raju", parsedName.getLastName());
    }

    @Test
    public void testParseTwoPartNameWithDot() {
        String nameToParse = "R. Jaiswal";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("R.", parsedName.getFirstName());
        Assertions.assertEquals("Jaiswal", parsedName.getLastName());
    }

    @Test
    public void testParseTwoPartNameWithDotAndComma() {
        String nameToParse = "Jaiswal, R.";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("R.", parsedName.getFirstName());
        Assertions.assertEquals("Jaiswal", parsedName.getLastName());
    }

    @Test
    public void testParseTwoPartNameWithNonEnglishLetters() {
        String nameToParse = "Søren Ålbæk";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("Søren", parsedName.getFirstName());
        Assertions.assertEquals("Ålbæk", parsedName.getLastName());
    }

    @Test
    public void testParseTwoPartNameWithApostrophe() {
        String nameToParse = "Antonio d'Angelo";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("Antonio", parsedName.getFirstName());
        Assertions.assertEquals("d'Angelo", parsedName.getLastName());
    }

    @Test
    public void testParseNameWithDash() {
        String nameToParse = "Lars Larsen-Jensen";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("Lars", parsedName.getFirstName());
        Assertions.assertEquals("Larsen-Jensen", parsedName.getLastName());
    }

    @Test
    public void testParseDutchName() {
        String nameToParse = "Dutch van der Linde";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("Dutch", parsedName.getFirstName());
        Assertions.assertEquals("van der Linde", parsedName.getLastName());
    }

    @Test
    public void testParseGermanName() {
        String nameToParse = "Günther von Berliner";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertEquals("Günther", parsedName.getFirstName());
        Assertions.assertEquals("von Berliner", parsedName.getLastName());
    }

    @Test
    public void testParseInvalidName() {
        String nameToParse = "Günther 342r";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        ParsedName parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertNull(parsedName);
    }
}
