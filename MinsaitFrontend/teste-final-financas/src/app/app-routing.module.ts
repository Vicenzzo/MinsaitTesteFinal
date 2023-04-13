import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ClientesComponent } from './pages/clientes/clientes.component';
import { EmprestimosComponent } from './pages/emprestimos/emprestimos.component';
import { CadastrarAtualizarClientesComponent } from './pages/cadastrar-atualizar-clientes/cadastrar-atualizar-clientes.component';
import { CadastrarEmprestimosComponent } from './pages/cadastrar-emprestimos/cadastrar-emprestimos.component';
import { QuemSomosComponent } from './pages/quem-somos/quem-somos.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'clientes', component: ClientesComponent},
  {path: 'clientes/cadastrar', component: CadastrarAtualizarClientesComponent},
  {path: 'clientes/editar/:cpf', component: CadastrarAtualizarClientesComponent},
  {path: 'clientes/deletar/:cpf', component: ClientesComponent},
  {path: 'clientes/:cpf/emprestimos', component: EmprestimosComponent},
  {path: 'clientes/:cpf/emprestimos/deletar/:id', component: EmprestimosComponent},
  {path: 'clientes/:cpf/emprestimos/cadastrar', component: CadastrarEmprestimosComponent},
  {path: 'quem-somos', component: QuemSomosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
