import AuthorNameParserApp.AuthorNameParser;
import AuthorNameParserApp.model.ParsedName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class AuthorNameParserTest {

    @Test
    public void testParseTwoPartName() {
        testName("Rahul Kumar", "Rahul", "Kumar");
    }

    private static void testName(String nameToParse, String Rahul, String Kumar) {
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals(Rahul, parsedName.get().getFirstName());
        Assertions.assertEquals(Kumar, parsedName.get().getLastName());
    }

    @Test
    public void testParseThreePartName() {
        testName("CH Ravindra Reddy", "CH Ravindra", "Reddy");
    }

    @Test
    public void testParseThreePartNameWithComma() {
        testName("Reddy, CH Ravindra", "CH Ravindra", "Reddy");
    }

    @Test
    public void testParseTwoPartNameWithComma() {
        testName("Raju, Banothu", "Banothu", "Raju");
    }

    @Test
    public void testParseTwoPartNameWithDot() {
        testName("R. Jaiswal", "R.", "Jaiswal");
    }

    @Test
    public void testParseTwoPartNameWithDotAndComma() {
        testName("Jaiswal, R.", "R.", "Jaiswal");
    }

    @Test
    public void testParseTwoPartNameWithNonEnglishLetters() {
        testName("Søren Ålbæk", "Søren", "Ålbæk");
    }

    @Test
    public void testParseTwoPartNameWithApostrophe() {
        testName("Antonio d'Angelo", "Antonio", "d'Angelo");
    }

    @Test
    public void testParseNameWithDash() {
        testName("Lars Larsen-Jensen", "Lars", "Larsen-Jensen");
    }

    @Test
    public void testParseDutchName() {
        testName("Dutch van der Linde", "Dutch", "van der Linde");
    }

    @Test
    public void testParseGermanName() {
        testName("Günther von Berliner", "Günther", "von Berliner");
    }

    @Test
    public void testParseInvalidName() {
        String nameToParse = "Günther 342r";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertFalse(parsedName.isPresent());
    }

    @Test
    public void testParseNameWithEmptyString() {
        String nameToParse = "";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertFalse(parsedName.isPresent());
    }

    @Test
    public void testParseNameWithNull() {
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(null);

        Assertions.assertFalse(parsedName.isPresent());
    }
}
