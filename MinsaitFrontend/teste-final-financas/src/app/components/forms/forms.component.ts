import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-forms',
  templateUrl: './forms.component.html',
  styleUrls: ['./forms.component.css']
})
export class FormsComponent {
  @Input() col:  string = 'col-3';
  @Input() nomeLabel: string = 'CEP';
  @Input() type: string = 'text';
  @Input() idInput: string = 'cep';
  @Input() controle!: FormControl;
  @Input() validar: boolean = false;
}
