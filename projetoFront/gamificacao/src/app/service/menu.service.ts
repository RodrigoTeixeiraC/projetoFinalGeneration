import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Tarefa } from '../model/Tarefa';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http: HttpClient) { }


  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllTarefas(): Observable<Tarefa[]> {

    return this.http.get<Tarefa[]>('http://localhost:8080.com/tarefa', this.token)
    
  }
}

