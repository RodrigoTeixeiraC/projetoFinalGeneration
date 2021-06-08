import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Tarefa } from '../model/Tarefa';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  constructor(private http: HttpClient) { }

  token ={
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  postTarefa(tarefa: Tarefa, id:number): Observable<Tarefa>{
    return this.http.post<Tarefa>(`http://localhost:8080/tarefa/${id}`,tarefa, this.token)
  }

  editarTarefa(tarefa: Tarefa): Observable<Tarefa>{
    return this.http.put<Tarefa>('http://localhost:8080/tarefa',tarefa, this.token)
  }

  confirmarTarefa(id: number): Observable<Tarefa>{
    return this.http.put<Tarefa>(`http://localhost:8080/tarefa/confirmar/${id}`, this.token)
  }

  deleteTarefa(id:number){
    return this.http.delete(`http://localhost:8080/tarefa/${id}`, this.token)
  }
}