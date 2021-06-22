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

  getAllTarefas(): Observable<Tarefa[]>{
    return this.http.get<Tarefa[]>('https://you-win.herokuapp.com/tarefa', this.token)
  }

  getTarefaById(id: number): Observable<Tarefa>{
    return this.http.get<Tarefa>(`https://you-win.herokuapp.com/tarefa/${id}`, this.token)
  }

  postTarefa(tarefa: Tarefa): Observable<Tarefa>{
    return this.http.post<Tarefa>('https://you-win.herokuapp.com/tarefa',tarefa, this.token)
  }

  editarTarefa(tarefa: Tarefa): Observable<Tarefa>{
    return this.http.put<Tarefa>('https://you-win.herokuapp.com/tarefa',tarefa, this.token)
  }

  confirmarTarefa(id: number): Observable<Tarefa>{
    return this.http.put<Tarefa>(`https://you-win.herokuapp.com/tarefa/confirmar/${id}`, '', this.token)
  }

  deleteTarefa(id:number){
    return this.http.delete(`http://localhost:8080/tarefa/${id}`, this.token)
  }

}