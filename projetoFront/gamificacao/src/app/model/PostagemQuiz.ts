import { Grupo } from "./Grupo"
import { Mentalidade } from "./Mentalidade"

export class PostagemQuiz{
    public id: string
    public pergunta: string
    public respostaCorreta: string
    public respostaFalsa: string
    public respostaFalsa2: string
    public pontuacao: number
    public mentalidade: Mentalidade// é enum
    public data: Date
    public grupoPostQuiz: Grupo
}