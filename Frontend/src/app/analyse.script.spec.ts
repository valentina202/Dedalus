import {AnalyseScript} from "./AnalyseScript";
import {TextDto} from "./TextDto";

describe('Analyse Script', () => {
  it('should be able to analyze the vowels of a text', () => {
    expect(new AnalyseScript().analyze(new TextDto(true, "Hello world")))
      .toEqual("H\nE\nL\nL\nO\n \nW\nO\nR\nL\nD\n" +
        "Letter 'A' appears 0 times\n" +
        "Letter 'E' appears 1 times\n" +
        "Letter 'I' appears 0 times\n" +
        "Letter 'O' appears 2 times\n" +
        "Letter 'U' appears 0 times\n");
  });
});

describe('Analyse Script', () => {
  it('should be able to analyze the consonants of a text', () => {
    expect(new AnalyseScript().analyze(new TextDto(false, "Hello world")))
      .toEqual(
        "Letter 'H' appears 1 times\n" +
        "Letter 'L' appears 3 times\n" +
        "Letter 'W' appears 1 times\n" +
        "Letter 'R' appears 1 times\n" +
        "Letter 'D' appears 1 times\n");
  });
});
