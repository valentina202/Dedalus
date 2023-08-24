package com.dedalus.codingtaskbackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitTests {

  private final TextServiceImpl textService = new TextServiceImpl();


  @Test
  void analyseTestVowels_noError() {
    String testString = "New test String";
    TextDto result = this.textService.analyse(true, testString);

    String wantedResult = "N\nE\nW\n \nT\nE\nS\nT\n \nS\nT\nR\nI\nN\nG\n" +
            "Letter 'A' appears 0 times\n" +
            "Letter 'E' appears 2 times\n" +
            "Letter 'I' appears 1 times\n" +
            "Letter 'O' appears 0 times\n" +
            "Letter 'U' appears 0 times\n";

    Assertions.assertEquals(wantedResult, result.text());

  }

  @Test
  void analyseTestConsonants_noError(){
    String testString = "New test String";
    TextDto result = this.textService.analyse(false, testString);

    String wantedResult = "Letter 'G' appears 1 times\n" +
            "Letter 'N' appears 2 times\n" +
            "Letter 'R' appears 1 times\n" +
            "Letter 'S' appears 2 times\n" +
            "Letter 'T' appears 3 times\n" +
            "Letter 'W' appears 1 times\n";

    Assertions.assertEquals(wantedResult, result.text());
  }
}
