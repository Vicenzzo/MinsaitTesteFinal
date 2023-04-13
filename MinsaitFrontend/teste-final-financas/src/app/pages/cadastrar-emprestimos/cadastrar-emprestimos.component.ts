import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EmprestimosService } from 'src/app/services/emprestimos.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IEmprestimo } from 'src/app/interfaces/emprestimo';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-cadastrar-emprestimos',
  templateUrl: './cadastrar-emprestimos.component.html',
  styleUrls: ['./cadastrar-emprestimos.component.css']
})
export class CadastrarEmprestimosComponent {
  Relacionamento: any = ['OURO', 'PRATA', 'BRONZE'];
  emprestimoForm = new FormGroup({
    valorInicial: new FormControl(0, Validators.required),
    relacionamento: new FormControl('', Validators.required),
    dataInicial: new FormControl('', Validators.required),
    dataFinal: new FormControl('', Validators.required)
  })
  constructor(private emprestimosService: EmprestimosService, private route: ActivatedRoute, private router: Router){}
  emprestimoCpf = 0;

  changeRelacionamento(e: any) {
    this.relacionamento?.setValue(e.target.value, {
      onlySelf: true,
    });
  }
  // Access formcontrols getter
  get relacionamento() {
    return this.emprestimoForm.get('relacionamento');
  }


  cadastrar(){
    const emprestimo: IEmprestimo = this.emprestimoForm.value as IEmprestimo;
    this.emprestimoCpf = Number(this.route.snapshot.paramMap.get('cpf'));

    this.emprestimosService.cadastrarEmprestimo(this.emprestimoCpf, emprestimo).subscribe(() => {
        Swal.fire({
          title: 'Sucesso',
          text: 'Emprestimo cadastrado',
          icon: 'success',
          confirmButtonText: 'Ok'
        }).then(() => {
          window.location.reload();
          });
      }, error => {
        Swal.fire({
          title: 'Erro',
          text: error(error),
          icon: 'error',
          confirmButtonText: 'Ok'
        });
    });
  }

}
