import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Atividades } from '../model/Atividades';
import { PostagemQuiz } from '../model/PostagemQuiz';

@Injectable({
  providedIn: 'root'
})
export class FeedServiceService {

  constructor(
    private http: HttpClient
      ) { }

      token = {
        headers: new HttpHeaders().set('Authorization', environment.token)
      }

      getAllPostagem(): Observable<PostagemQuiz[]>{
        return this.http.get<PostagemQuiz[]>('http://localhost:8080/postagem-quiz', this.token)
      }

      getAllAtividades(): Observable<Atividades[]>{
        return this.http.get<Atividades[]>('http://localhost:8080/atividades', this.token)
      }
}
