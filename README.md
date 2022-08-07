# AuthorNameParser

Project to parse author names and separate first and last names.

## Usage:

Add AuthorNameParser maven Project

In pom.xml add:
```
<dependency>
  <groupId>groupId</groupId>
  <artifactId>AuthorNameParser</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

In project reference like this:
```
AuthorNameParser authorNameParser = new AuthorNameParser();
```

Name parsing example:
```
Optional<ParsedName>parsedName = authorNameParser.parseName("Jens Jensen");
```

Accessing first and last name:
```
parsedName.get().getFirstName()
parsedName.get().getLastName()
```
