package com.dedalus.codingtaskbackend;


public interface TextService {

  /**
   * Anaylses the given text, by counting the occurrence of the given consonants and all vowels
   * @param vowels decides if the vowels or consonants will be analyzed
   * @param text contains the given Text
   * @return a String[] with the analysed data
   */
  TextDto analyse(boolean vowels, String text);
}
