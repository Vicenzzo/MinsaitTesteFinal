import { Component } from '@angular/core';
import { IEmprestimo } from 'src/app/interfaces/emprestimo';
import { EmprestimosService } from 'src/app/services/emprestimos.service';
import { ActivatedRoute, Route, Router} from '@angular/router';
@Component({
  selector: 'app-emprestimos',
  templateUrl: './emprestimos.component.html',
  styleUrls: ['./emprestimos.component.css']
})
export class EmprestimosComponent {
  emprestimoCpf = 0;
  emprestimoId = 0;
  emprestimos: IEmprestimo[] = [];

  constructor(private emprestimoService: EmprestimosService, private route: ActivatedRoute, private router: Router){}
  ngOnInit(){
    this.emprestimoCpf = Number(this.route.snapshot.paramMap.get('cpf'));
    this.emprestimoId = Number(this.route.snapshot.paramMap.get('id'));
    this.emprestimoService.buscarTodosEmprestimosPorCliente(this.emprestimoCpf).subscribe((result: IEmprestimo[]) => {
      this.emprestimos = result;
    })
    if(this.emprestimoCpf && this.emprestimoId){
      this.deletar();
    }

  }
  deletar(){
    this.emprestimoService.deletarEmprestimo(this.emprestimoCpf, this.emprestimoId).subscribe(() => {
      this.router.navigateByUrl(`/clientes/${this.emprestimoCpf}/emprestimos`);
    }, error => {
      console.error(error);
    })
  }
}
