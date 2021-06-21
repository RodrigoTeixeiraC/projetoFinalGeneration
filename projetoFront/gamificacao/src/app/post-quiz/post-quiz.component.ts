
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';

import { Grupo } from '../model/Grupo';
import { InscricaoGrupo } from '../model/InscricaoGrupo';
import { PostagemQuiz } from '../model/PostagemQuiz';
import { Usuario } from '../model/Usuario';
import { AlertasService } from '../service/alertas.service';

import { GrupoPostService } from '../service/grupo-post.service';
import { UsuarioService } from '../service/usuario.service';

@Component({
  selector: 'app-post-quiz',
  templateUrl: './post-quiz.component.html',
  styleUrls: ['./post-quiz.component.css']
})
export class PostQuizComponent implements OnInit {
   
  grupo:Grupo = new Grupo()
  inscricao: InscricaoGrupo = new InscricaoGrupo()
  postQuiz:PostagemQuiz = new PostagemQuiz
  user: Usuario = new Usuario()
  idUser = environment.id
  txtBotaoQuiz: string
  txtBotaoInscricao: string
  usuario: Usuario = new Usuario()
  

 
  constructor(
    private postQuizService: GrupoPostService,
    private router:Router, 
    private raute:ActivatedRoute,
    private alertas: AlertasService,
    private usuarioService: UsuarioService
  ) { }

  ngOnInit(){
    window.scroll(0,0)
    
    if(environment.token == ''){
      this.alertas.showAlertInfo('Sua seção expirou, faça o login novamente.')
      this.router.navigate(['/login'])
    }

   let id = this.raute.snapshot.params['id']
   this.findGrupoById(id)
   this.findUsuarioById()   
  }

  findGrupoById(id: number){
    this.postQuizService.getGrupoById(id).subscribe((resp: Grupo)=>{
      this.grupo= resp
    })
  }

  findUsuarioById(){
    this.usuarioService.getUsuarioById(this.idUser).subscribe((resp: Usuario) => {
      this.usuario = resp
      console.log(this.usuario)
      console.log(this.grupo.criador)
    })
  }

 botaoQuiz(){
    if (this.usuario == this.grupo.criador){
      this.txtBotaoQuiz = "Novo Quiz"
    } else{
      document.querySelector("#botaoQuiz")?.setAttribute("style", "display: none;")
  }
}

botaoInscricao(){
  if(this.usuario != this.grupo.criador){
    this.txtBotaoInscricao = "Seguir grupo"
  } else{
    document.querySelector("#botaoInscricao")?.setAttribute("style", "display: none;")
    console.log(this.grupo.criador)
  }
}

  publicar(){
    
    this.postQuiz.grupoPostQuiz = this.grupo
    this.postQuizService.postPostagemQuiz(this.postQuiz).subscribe((resp: PostagemQuiz)=>{
      this.postQuiz= resp
      this.alertas.showAlertSuccess ("Postagem realizada com sucesso!")
      this.postQuiz = new PostagemQuiz()
      let id = this.raute.snapshot.params['id']
      this.findGrupoById(id)
    }) 
    
    }

    inscricaoGU(){
      this.user.id = this.idUser
      this.inscricao.usuarioInscricao = this.user
      this.inscricao.grupoInscricao = this.grupo

      this.postQuizService.postInscricao(this.inscricao).subscribe((resp: InscricaoGrupo) => {
        this.inscricao = resp
        this.alertas.showAlertSuccess('Inscrição realizada com sucesso!')
        this.findGrupoById(this.grupo.id)
      })
      
    }

}

