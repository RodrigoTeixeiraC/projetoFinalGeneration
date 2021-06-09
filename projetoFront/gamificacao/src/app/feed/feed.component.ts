import { Component, OnInit } from '@angular/core';
import { Atividades } from '../model/Atividades';
import { PostagemQuiz } from '../model/PostagemQuiz';
import { FeedServiceService } from '../service/feed-service.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {
  listaPostagens: any[]
  listaAtividades: any[]

  constructor(
    private serviceFeed: FeedServiceService
  ) { }

  ngOnInit(){
    this.findAllPostagens()
    this.findAllAtividades()
    this.juntarListas()
  }

  findAllPostagens(){
    this.serviceFeed.getAllPostagem().subscribe((resp: PostagemQuiz[]) =>{
      this.listaPostagens = resp
    })
    }

  findAllAtividades(){
    this.serviceFeed.getAllAtividades().subscribe((resp: Atividades[]) =>{
      this.listaAtividades = resp
    })
  }

  juntarListas(){
    this.listaPostagens.concat(this.listaAtividades)
    console.log(this.listaPostagens)
  }

}
