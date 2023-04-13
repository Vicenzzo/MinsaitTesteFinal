import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environment/environment';
import { IEmprestimo } from '../interfaces/emprestimo';

@Injectable({
  providedIn: 'root'
})
export class EmprestimosService {
  endpoint = 'clientes'
  api = environment.api;
  constructor(private http: HttpClient) { }

  buscarTodosEmprestimosPorCliente(cpf: number){
    return this.http.get<IEmprestimo[]>(`${this.api}/${this.endpoint}/${cpf}/emprestimos`);
  }
  cadastrarEmprestimo(cpf: number, emprestimo: IEmprestimo){
    return this.http.post(`${this.api}/${this.endpoint}/${cpf}/emprestimos`, emprestimo);
  }
  deletarEmprestimo(cpf: number, id: number){
    return this.http.delete(`${this.api}/${this.endpoint}/${cpf}/emprestimos/${id}`);
  }

}
