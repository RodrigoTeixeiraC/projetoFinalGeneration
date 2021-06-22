import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Grupo } from '../model/Grupo';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  constructor(
    private http: HttpClient
  ) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllGrupos(): Observable<Grupo[]>{
    return this.http.get<Grupo[]>('https://you-win.herokuapp.com/grupo',this.token)
  }

  getGrupoById(id: number): Observable<Grupo>{
    return this.http.get<Grupo>(`https://you-win.herokuapp.com/grupo/${id}`)
  }

  postGrupo(grupo: Grupo): Observable<Grupo>{
    return this.http.post<Grupo>('https://you-win.herokuapp.com/usuario/novo-grupo', grupo, this.token)
  }
}
