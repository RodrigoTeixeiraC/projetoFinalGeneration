import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Tarefa } from '../model/Tarefa';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http: HttpClient) { }


  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllTarefas(): Observable<Tarefa[]> {
    return this.http.get<Tarefa[]>('https://you-win.herokuapp.com/tarefa', this.token) 
  }
  atualizarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>('https://you-win.herokuapp.com/usuario', usuario, this.token)
  }
}

