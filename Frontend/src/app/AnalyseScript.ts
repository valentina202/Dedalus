import {TextDto} from "./TextDto";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class AnalyseScript {
  private vowels: string = "AEIOU";
  private consonants: string = "BCDFGHJKLMNPQRSTVWXYZ";

  analyze(textDto: TextDto): string {
    textDto.text = textDto.text.toUpperCase();
    let results: string = "";
    if (textDto.vowels) {
      results += this.evaluate(textDto, this.vowels, results)
      return results;
    } else {
      return this.evaluate(textDto, this.consonants, results);
    }
  }

  private evaluate(textDto: TextDto, analyseString: string, results: string): string {
    const map: { [key: string]: number } = {};

    if (textDto.vowels) {
      for (const letter of analyseString) {
        map[letter] = 0;
      }
      for (let i = 0; i < textDto.text.length; i++) {
        results += textDto.text.charAt(i) + "\n";
      }
    }
    for (const letter of textDto.text) {
      if (analyseString.includes(letter)) {
        if (!map[letter]) {
          map[letter] = 1;
        } else {
          map[letter] = map[letter] + 1;
        }
      }
    }
    for (const [key, value] of Object.entries(map)) {
      results += `Letter '${key}' appears ${value} times\n`;
    }
    return results;
  }
}
