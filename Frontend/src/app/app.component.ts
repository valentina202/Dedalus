import {Component, OnInit} from '@angular/core';
import {AnalyseService} from "./Service/AnalyseService";
import {NgModel} from "@angular/forms";
import {TextDto} from "./TextDto";
import {AnalyseScript} from "./AnalyseScript";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  sentence: TextDto = {
    vowels: true,
    text: ''
  };
  result: TextDto = {
    vowels: true,
    text: ''
  };
  allResults: TextDto = {
    vowels: true,
    text: ''
  }
  online: boolean;


  constructor(
    private analyseService: AnalyseService,
    private analyseScript: AnalyseScript
  ) {
  }

  /**
   * on Submit
   */
  submit() {
    if (this.online) {
      this.analyseService.analyze(this.sentence).subscribe({
        next: data => {
          this.result = data;
        }
      });
      console.log('Analyse: ' + this.result.text);
    }
    else{
      this.result.text = this.analyseScript.analyze(this.sentence);
    }
  }

  ngOnInit()
    :
    void {
  }



  dynamicCssClassesForInput(input:NgModel):
    any {
    return {
      // This names in this object are determined by the style library,
      // requiring it to follow TypeScript naming conventions does not make sense.
      // eslint-disable-next-line @typescript-eslint/naming-convention
      'is-invalid': !input.valid && !input.pristine,
    };
  }
}
