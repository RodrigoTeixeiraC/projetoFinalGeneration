package com.gamificacao.projetogamificacao.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Repository.AtividadesRepository;

@Service
public class AtividadesService {
	
	private @Autowired Usuario usario;
	private @Autowired AtividadesRepository atividadesRepository;
	
}
	
	
