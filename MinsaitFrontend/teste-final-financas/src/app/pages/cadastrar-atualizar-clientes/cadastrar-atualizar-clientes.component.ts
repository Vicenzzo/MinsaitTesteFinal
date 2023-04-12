import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ICliente } from 'src/app/interfaces/cliente';
import { ClientesService } from 'src/app/services/clientes.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastrar-atualizar-clientes',
  templateUrl: './cadastrar-atualizar-clientes.component.html',
  styleUrls: ['./cadastrar-atualizar-clientes.component.css']
})
export class CadastrarAtualizarClientesComponent {
  clienteForm = new FormGroup({
    cpf: new FormControl(0, Validators.required),
    nome: new FormControl('', Validators.required),
    telefone: new FormControl(0, Validators.required),
    cep: new FormControl(0, Validators.required),
    rua: new FormControl(0, Validators.required),
    numeroDaResidencia: new FormControl(0, Validators.required),
    rendimentoMensal: new FormControl(0, Validators.required)
  })
  constructor(private clienteService: ClientesService){}

  cadastrar(){
    const cliente: ICliente = this.clienteForm.value as ICliente;

    this.clienteService.cadastrarCliente(cliente).subscribe(() => {
        Swal.fire({
          title: 'Sucesso',
          text: 'Livro cadastrado',
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
