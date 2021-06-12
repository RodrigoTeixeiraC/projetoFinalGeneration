
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Grupo } from '../model/Grupo';
import { PostagemQuiz } from '../model/PostagemQuiz';

import { GrupoPostService } from '../service/grupo-post.service';

@Component({
  selector: 'app-post-quiz',
  templateUrl: './post-quiz.component.html',
  styleUrls: ['./post-quiz.component.css']
})
export class PostQuizComponent implements OnInit {
   
  grupo:Grupo = new Grupo()
  postQuiz:PostagemQuiz = new PostagemQuiz

 
  constructor(
    private postQuizService: GrupoPostService,
    private rauter:Router, 
    private raute:ActivatedRoute
  ) { }

  ngOnInit(){
   let id = this.raute.snapshot.params['id']
   this.findGrupoById(id)
  }

  findGrupoById(id: number){
    this.postQuizService.getGrupoById(id).subscribe((resp: Grupo)=>{
      this.grupo= resp
    })
  }
  publicar(){
    
    this.postQuiz.grupoPostQuiz = this.grupo
    this.postQuizService.postPostagemQuiz(this.postQuiz).subscribe((resp: PostagemQuiz)=>{
      this.postQuiz= resp
      alert ("Postagem realizada com sucesso!")
      this.postQuiz = new PostagemQuiz()
    }) 
    
    }

}

