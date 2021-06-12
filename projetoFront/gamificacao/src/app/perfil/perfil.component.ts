import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  txtBtnAdAmigo: string = "adicionar amigue"
 
  constructor(
    private rauter:Router
  ) { }
  
  ngOnInit() {
  

  }

  addAmigo() {
    

    if(this.txtBtnAdAmigo == "adicionar amigue") {
      this.txtBtnAdAmigo = "merjou"
      document.querySelector("#addAmigo")?.setAttribute("style", "display: none;")
      

    } else {
      this.txtBtnAdAmigo = "adicionar amigue"  
      // para adicionar amigo, retornar o enum, pegar a resposta do enum (estado atual). Fazer get do estado atual do enum. 
      
    }


  }
}
