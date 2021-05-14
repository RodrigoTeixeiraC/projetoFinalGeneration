package com.gamificacao.projetogamificacao.Service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.Models.Atividades;
import com.gamificacao.projetogamificacao.Models.Grupo;
import com.gamificacao.projetogamificacao.Models.InscricaoGrupo;
import com.gamificacao.projetogamificacao.Models.PostagemQuiz;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Models.UsuarioLogin;
import com.gamificacao.projetogamificacao.Repository.GrupoRepository;
import com.gamificacao.projetogamificacao.Repository.PostagemQuizRepository;
import com.gamificacao.projetogamificacao.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private GrupoRepository repositoryGrupo;
	
	@Autowired 
	private PostagemQuizRepository PostQuizRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

		Optional<Usuario> usuarioExistente = repository.findByUsuarioOrEmail(usuario.getUsuario(), usuario.getEmail());

		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		} else {
			BCryptPasswordEncoder ecoder = new BCryptPasswordEncoder();

			String senhaEcoder = ecoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEcoder);

			return Optional.ofNullable(repository.save(usuario));
		}
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuarioOrEmail(user.get().getUsuario(), user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha()))
				;

			String auth = user.get().getUsuario() + ":" + user.get().getSenha();
			byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
			String authHeader = "Basic " + new String(encodeAuth);

			user.get().setToken(authHeader);

			return user;
		}
		return null;
	}

	/**
	 * Cria um Grupo e seta o usuario existente como seu criador
	 * 
	 * @param novoGrupo uma Entidade Grupo
	 * @param idUsuario tipo Long
	 * @return Optional com entidade usuario, caso usuario existente ou um Optional
	 *         vazio
	 * @since 1.0
	 * @author Rive
	 */
	public Optional<Usuario> criarGrupo(Grupo novoGrupo, Long idUsuario) {
		return repository.findById(idUsuario).map(usuarioExistente -> {
			novoGrupo.setCriador(usuarioExistente);
			repositoryGrupo.save(novoGrupo);
			return repository.findById(idUsuario);
		}).orElse(Optional.empty());
	}

	public Optional<Usuario> aceitarnoGrupo(Grupo novointegrante, Long idGrupo) {
		return repository.findById(idGrupo).map(GrupoExistente -> {
			novointegrante.setCriador(GrupoExistente);
			repositoryGrupo.save(novointegrante);
			return repository.findById(idGrupo);
		}).orElse(Optional.empty());
	}

	public List<Atividades> buscarAtividades(Usuario usuario) {

		Set<Usuario> listaAmigos = usuario.getClan();
		List<Atividades> atividades = usuario.getAtividadesUsuario();

		for (Usuario i : listaAmigos) {

			for (Atividades x : atividades) {

				return atividades;
			}
		}
		return null;
	}
	

	public Optional<List<PostagemQuiz>> buscarPostQuiz (Usuario usuario){
	
		List<InscricaoGrupo> gruposInscritos = usuario.getListaInscricaoUG();
		
		gruposInscritos.stream()
		.map(grupo -> 
			grupo.getGrupoInscricao().getListaPostQuiz()
				.stream()
				.map(postQuiz -> {
					postQuiz.getId();
					return PostQuizRepository.findById(postQuiz);
					}).orElse(Optional.empty())).orElse(Optional.empty());
		
	}
}
