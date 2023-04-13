import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { ClientesComponent } from './pages/clientes/clientes.component';
import { EmprestimosComponent } from './pages/emprestimos/emprestimos.component';

import {HttpClientModule} from '@angular/common/http'
import { ReactiveFormsModule } from '@angular/forms';
import { CadastrarAtualizarClientesComponent } from './pages/cadastrar-atualizar-clientes/cadastrar-atualizar-clientes.component';
import { CadastrarEmprestimosComponent } from './pages/cadastrar-emprestimos/cadastrar-emprestimos.component';
import { FormsComponent } from './components/forms/forms.component';
import { CurrencyMaskModule } from "ng2-currency-mask";
import { QuemSomosComponent } from './pages/quem-somos/quem-somos.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ClientesComponent,
    EmprestimosComponent,
    CadastrarAtualizarClientesComponent,
    CadastrarEmprestimosComponent,
    FormsComponent,
    QuemSomosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    CurrencyMaskModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
