import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Grupo } from '../model/Grupo';
import { InscricaoGrupo } from '../model/InscricaoGrupo';
import { Usuario } from '../model/Usuario';
import { GrupoService } from '../service/grupo.service';
import { UsuarioService } from '../service/usuario.service';

@Component({
  selector: 'app-grupos',
  templateUrl: './grupos.component.html',
  styleUrls: ['./grupos.component.css']
})
export class GruposComponent implements OnInit {

  id = environment.id

  todosGrupos: Grupo[]
  gruposQueParticipo: Grupo[]
  usuario: Usuario = new Usuario
  foto: string
  grupo: Grupo = new Grupo()

  constructor(
    private router: Router,
    private usuarioService: UsuarioService,
    private grupoService: GrupoService
  ) { }

  ngOnInit(){
    window.scroll(0,0)
    
    if(environment.token == ''){
      alert('Sua seção expirou, faça o login novamente.')
      this.router.navigate(['/login'])
    }

    this.findUsuarioById()
  }

  findUsuarioById(){
    this.usuarioService.getUsuarioById(this.id).subscribe((resp: Usuario) => {
      this.usuario = resp
    })
  }

  findAllGrupos(){
    this.grupoService.getAllGrupos().subscribe((resp: Grupo[]) =>{
      this.todosGrupos = resp
    })
  }

  criarGrupo(){
    this.usuario.id = this.id
    this.grupo.criador = this.usuario
    
    this.grupoService.postGrupo(this.grupo).subscribe((resp: Grupo) => {
      this.grupo = resp
      alert('Grupo criado com sucesso!')
      this.grupo = new Grupo()
      this.findUsuarioById()
    })
  }

}
