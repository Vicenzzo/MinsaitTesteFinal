import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { ICliente } from '../interfaces/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  endpoint = 'clientes'
  api = environment.api;
  constructor(private http: HttpClient) { }

  buscarTodosClientes(){
    return this.http.get<ICliente[]>(`${this.api}/${this.endpoint}`);
  }
  cadastrarCliente(cliente: ICliente){
    return this.http.post(`${this.api}/${this.endpoint}`, cliente);
  }
  buscarClientePorCpf(cpf: number){
    return this.http.get<ICliente>(`${this.api}/${this.endpoint}/${cpf}`);
  }
  atualizarCliente(cpf: number, cliente: ICliente){
    return this.http.put(`${this.api}/${this.endpoint}/${cpf}`, cliente);
  }
  deletarCliente(cpf: number){
    return this.http.delete(`${this.api}/${this.endpoint}/${cpf}`);
  }
}
