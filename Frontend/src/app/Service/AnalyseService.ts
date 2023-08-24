import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {TextDto} from "../TextDto";

const baseUri = 'http://localhost:8080/analyse';

@Injectable({
  providedIn: 'root'
})
export class AnalyseService {

  constructor(
    private http: HttpClient,
  ) {
  }

  /**
   * Get String[] with analysed text, by counting the occurrence of the given consonants and all vowels
   * @param text text to analyse
   * @return an Observable with the wanted to be analysed data
   */
  analyze(text: TextDto): Observable<TextDto> {
    return this.http.post<TextDto>(baseUri, text);
  }
}
