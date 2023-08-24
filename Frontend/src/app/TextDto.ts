export class TextDto {
  constructor(vowels: boolean, text: string) {
    this.vowels = vowels;
    this.text = text;
  }

  vowels: boolean;
  text: string;
}
