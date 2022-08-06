import AuthorNameParserApp.AuthorNameParser;
import AuthorNameParserApp.model.ParsedName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class AuthorNameParserTest {

    @Test
    public void testParseTwoPartName() {
        String nameToParse = "Rahul Kumar";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("Rahul", parsedName.get().getFirstName());
        Assertions.assertEquals("Kumar", parsedName.get().getLastName());
    }

    @Test
    public void testParseThreePartName() {
        String nameToParse = "CH Ravindra Reddy";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("CH Ravindra", parsedName.get().getFirstName());
        Assertions.assertEquals("Reddy", parsedName.get().getLastName());
    }

    @Test
    public void testParseThreePartNameWithComma() {
        String nameToParse = "Reddy, CH Ravindra";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("CH Ravindra", parsedName.get().getFirstName());
        Assertions.assertEquals("Reddy", parsedName.get().getLastName());
    }

    @Test
    public void testParseTwoPartNameWithComma() {
        String nameToParse = "Raju, Banothu";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("Banothu", parsedName.get().getFirstName());
        Assertions.assertEquals("Raju", parsedName.get().getLastName());
    }

    @Test
    public void testParseTwoPartNameWithDot() {
        String nameToParse = "R. Jaiswal";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("R.", parsedName.get().getFirstName());
        Assertions.assertEquals("Jaiswal", parsedName.get().getLastName());
    }

    @Test
    public void testParseTwoPartNameWithDotAndComma() {
        String nameToParse = "Jaiswal, R.";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("R.", parsedName.get().getFirstName());
        Assertions.assertEquals("Jaiswal", parsedName.get().getLastName());
    }

    @Test
    public void testParseTwoPartNameWithNonEnglishLetters() {
        String nameToParse = "Søren Ålbæk";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("Søren", parsedName.get().getFirstName());
        Assertions.assertEquals("Ålbæk", parsedName.get().getLastName());
    }

    @Test
    public void testParseTwoPartNameWithApostrophe() {
        String nameToParse = "Antonio d'Angelo";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("Antonio", parsedName.get().getFirstName());
        Assertions.assertEquals("d'Angelo", parsedName.get().getLastName());
    }

    @Test
    public void testParseNameWithDash() {
        String nameToParse = "Lars Larsen-Jensen";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("Lars", parsedName.get().getFirstName());
        Assertions.assertEquals("Larsen-Jensen", parsedName.get().getLastName());
    }

    @Test
    public void testParseDutchName() {
        String nameToParse = "Dutch van der Linde";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("Dutch", parsedName.get().getFirstName());
        Assertions.assertEquals("van der Linde", parsedName.get().getLastName());
    }

    @Test
    public void testParseGermanName() {
        String nameToParse = "Günther von Berliner";
        AuthorNameParser authorNameParser = new AuthorNameParser();
        Optional<ParsedName> parsedName = authorNameParser.parseName(nameToParse);

        Assertions.assertTrue(parsedName.isPresent());
        Assertions.assertEquals("Günther", parsedName.get().getFirstName());
        Assertions.assertEquals("von Berliner", parsedName.get().getLastName());
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
