import { AprovacaoAmigos } from "./AprovacaoAmigos"
import { Atividades } from "./Atividades"
import { Grupo } from "./Grupo"
import { InscricaoGrupo } from "./InscricaoGrupo"
import { Tarefa } from "./Tarefa"

export class Usuario{
    public id: number
    public usuario: string
    public nome: string
    public sobrenome: string
    public email: string
    public celular: number
    public dataNascimento: Date
    public responsabilidadePessoal: number
    public mentalidadeCrescimento: number
    public orientacaoFuturo: number
    public persistencia: number
    public senha: string
    public foto: string
    public avatar: string
    public aprovacao: AprovacaoAmigos[]
    public meusPedidosAmizade: AprovacaoAmigos[]
    public gruposCriados: Grupo[]
    public atividesUsuario: Atividades[]
    public listaInscricaoUG: InscricaoGrupo[]
    public listaTarefas: Tarefa[] 
}