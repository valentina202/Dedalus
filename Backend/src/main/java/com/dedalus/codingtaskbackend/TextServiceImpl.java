package com.dedalus.codingtaskbackend;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.TreeMap;

@Service
public class TextServiceImpl implements TextService {

  @Override
  public TextDto analyse(boolean vowels, String text) {
    String results = "";
    text = text.toUpperCase(Locale.ROOT);
    if (vowels) {
      char[] chars = text.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        results += chars[i] + "\n";
      }
      String vowelsString = "AEIOU";
      results = evaluate(text, true, results, vowelsString);
    } else {
      String consonants = "BCDFGHJKLMNPQRSTVWXYZ";
      results = evaluate(text, false, results, consonants);
    }
    return new TextDto(vowels, results);
  }

  private String evaluate(String text, boolean vowels, String results, String analyseString) {
    StringBuilder resultsBuilder = new StringBuilder(results);
    TreeMap<String, Integer> map = new TreeMap<>();
    //All vowels should appear in the end string if chosen.
    if (vowels){
      for (char letter:analyseString.toCharArray()) {
        map.putIfAbsent(String.valueOf(letter), 0);
      }
    }

    for (char letter : text.toCharArray()) {
      if (analyseString.contains(String.valueOf(letter))) {
        Integer value = map.putIfAbsent(String.valueOf(letter), 1);
        if (value != null) {
          map.put(String.valueOf(letter), value + 1);
        }
      }
    }
    map.entrySet().forEach(entrySet -> {
      resultsBuilder.append("Letter '").append(entrySet.getKey()).append("' appears ").append(entrySet.getValue()).append(" times").append("\n");
    });
    results = resultsBuilder.toString();
    return results;
  }
}