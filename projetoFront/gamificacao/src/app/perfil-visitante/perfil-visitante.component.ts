import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';
import { UsuarioService } from '../service/usuario.service';

@Component({
  selector: 'app-perfil-visitante',
  templateUrl: './perfil-visitante.component.html',
  styleUrls: ['./perfil-visitante.component.css']
})
export class PerfilVisitanteComponent implements OnInit {

  txtBtnAdAmigo: string = "adicionar amigue"
  nome = environment.nome
  foto = environment.foto
  

  usuario: Usuario = new Usuario()
  idUsuario: number
  confirmarSenha: string
  

 
  constructor(
    private usuarioService: UsuarioService,
    private authService: AuthService,
    private raute: ActivatedRoute,
    private router: Router,
    private alertas: AlertasService
    
  ) { }
  
  ngOnInit() {
  
    window.scroll(0,0)

    if(environment.token == ''){
      this.alertas.showAlertInfo('Sua seção expirou, faça o login novamente.')
      this.router.navigate(['/login'])
    }
    let id = this.raute.snapshot.params['id']
    this.findByIdUsuario(id)
  }

  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
  }


  findByIdUsuario(id: number) {
    this.usuarioService.getUsuarioById(id).subscribe((resp: Usuario) => {
      this.usuario = resp
    })
  
  }
 
//perfil de visitante
  
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