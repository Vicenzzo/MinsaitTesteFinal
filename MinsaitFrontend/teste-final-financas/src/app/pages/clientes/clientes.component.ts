import { Component } from '@angular/core';
import { ICliente } from 'src/app/interfaces/cliente';
import { ClientesService } from 'src/app/services/clientes.service';
import { ActivatedRoute, Route, Router} from '@angular/router';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent {
  clienteCpf = 0;
  clientes: ICliente[] = [];

  constructor(private clientesService: ClientesService, private route: ActivatedRoute, private router: Router){}

  ngOnInit(){
    this.clienteCpf = Number(this.route.snapshot.paramMap.get('cpf'));
    this.clientesService.buscarTodosClientes().subscribe((result: ICliente[]) => {
      this.clientes = result;
    })
    if(this.clienteCpf){
      this.deletar();
    }
  }
  deletar(){
    this.clientesService.deletarCliente(this.clienteCpf).subscribe(() => {
      this.router.navigateByUrl('/clientes');
    }, error => {
      console.error(error);
    })
  }
}
