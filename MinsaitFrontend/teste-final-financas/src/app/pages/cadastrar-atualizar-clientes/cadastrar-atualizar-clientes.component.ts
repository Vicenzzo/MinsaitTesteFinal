import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ICliente } from 'src/app/interfaces/cliente';
import { ClientesService } from 'src/app/services/clientes.service';
import { ActivatedRoute, Router } from '@angular/router';
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
    telefone: new FormControl(11923456789, Validators.required),
    cep: new FormControl('', Validators.required),
    rua: new FormControl('', Validators.required),
    numeroDaResidencia: new FormControl(0, Validators.required),
    rendimentoMensal: new FormControl(0, Validators.required)
  })
  constructor(private clienteService: ClientesService, private route: ActivatedRoute, private router: Router){}
  clienteCpf = 0;

  ngOnInit(){
    this.clienteCpf = Number(this.route.snapshot.paramMap.get('cpf'));
    if(this.clienteCpf){
      this.clienteService.buscarClientePorCpf(this.clienteCpf).subscribe((cliente: ICliente) => {
        this.clienteForm.setValue({
          cpf: cliente.cpf || 0,
          nome: cliente.nome || '',
          telefone: cliente.telefone || 11923456789,
          cep: cliente.cep || '',
          rua: cliente.rua || '',
          numeroDaResidencia: cliente.numeroDaResidencia || 0,
          rendimentoMensal: cliente.rendimentoMensal || 0
        })
      })
    }
  }


  cadastrar(){
    const cliente: ICliente = this.clienteForm.value as ICliente;

    this.clienteService.cadastrarCliente(cliente).subscribe(() => {
        Swal.fire({
          title: 'Sucesso',
          text: 'Cliente cadastrado',
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
  editar(){
    const cliente: ICliente = this.clienteForm.value as ICliente;
    this.clienteService.atualizarCliente(this.clienteCpf, cliente).subscribe(() => {
      Swal.fire({
        title: 'Sucesso',
        text: 'Cliente alterado',
        icon: 'success',
        confirmButtonText: 'Ok'
      }).then(() => {
        this.router.navigateByUrl('/clientes');
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
  cadastrarOuEditar(){
    if(this.clienteCpf){
      this.editar();
    }else{
      this.cadastrar();
    }
  }

}
