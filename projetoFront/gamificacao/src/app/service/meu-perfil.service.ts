import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class MeuPerfilService {

  constructor(private http: HttpClient) { }

  token = { 
   headers: new HttpHeaders().set('Authorization', environment.token)
  }


  
}
