package com.dedalus.codingtaskbackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitTests {

  private final TextServiceImpl textService = new TextServiceImpl();


  @Test
  void analyseTestVowels_noError() {
    String testString = "New test String";
    TextDto result = this.textService.analyse(true, testString);

    String wantedResult = "Letter 'A' appears 0 times\nLetter 'E' appears 2 times\nLetter 'I' appears 1 times\nLetter 'O' appears 0 times\nLetter 'U' appears 0 times\n";

    Assertions.assertEquals(wantedResult, result.text());

  }

  @Test
  void analyseTestConsonants_noError(){
    String testString = "New test String";
    TextDto result = this.textService.analyse(false, testString);

    String wantedResult = "Letter 'G' appears 1 times\nLetter 'N' appears 2 times\nLetter 'R' appears 1 times\nLetter 'S' appears 2 times\nLetter 'T' appears 3 times\nLetter 'W' appears 1 times\n";

    Assertions.assertEquals(wantedResult, result.text());
  }
}
