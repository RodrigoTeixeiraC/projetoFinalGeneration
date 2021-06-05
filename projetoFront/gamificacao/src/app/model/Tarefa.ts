import { Usuario } from "./Usuario"

export class Tarefa{
    public id: number
    public titulo: string
    public descricao: string
    public status: boolean
    public usuarioResponsavel: Usuario
}