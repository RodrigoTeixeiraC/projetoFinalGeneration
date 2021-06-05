import { Grupo } from "./Grupo"
import { Usuario } from "./Usuario"

export class InscricaoGrupo{
    public id: number
    public aprovacao: string //é um enum
    public usuarioInscricao: Usuario
    public grupoInscricao: Grupo
}