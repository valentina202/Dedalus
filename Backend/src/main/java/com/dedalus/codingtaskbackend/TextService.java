package com.dedalus.codingtaskbackend;


public interface TextService {

  /**
   * Anaylses the given text, by counting the occurrence of the given consonants and all vowels
   * @param text contains the given Text
   * @return a String[] with the analysed data
   */
  TextDto analyse(boolean vowels, String text);
}
