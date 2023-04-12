import { Component } from '@angular/core';
import { ICliente } from 'src/app/interfaces/cliente';
import { ClientesService } from 'src/app/services/clientes.service';
import { ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent {
  clienteCpf = 0;
  clientes: ICliente[] = [];

  constructor(private clientesService: ClientesService, private route: ActivatedRoute){}

  ngOnInit(){
    this.clienteCpf = Number(this.route.snapshot.paramMap.get('cpf'));
    this.clientesService.buscarTodosClientes().subscribe((result: ICliente[]) => {
      this.clientes = result;
    })
  }
}
