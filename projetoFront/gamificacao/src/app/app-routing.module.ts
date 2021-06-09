import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { FeedComponent } from './feed/feed.component';
import { LoginComponent } from './login/login.component';
import { TarefasComponent } from './tarefas/tarefas.component';

const routes: Routes = [

  {path: '', redirectTo: 'login', pathMatch: 'full'},

  {path: 'login', component: LoginComponent},
  {path: 'cadastrar', component: CadastrarComponent},

  {path: 'feed', component: FeedComponent},
  {path: 'tarefas', component: TarefasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
