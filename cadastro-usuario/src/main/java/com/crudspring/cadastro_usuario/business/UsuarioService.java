package com.crudspring.cadastro_usuario.business;

/*
 * precisa injetar a dependencia do repository dentro da classe Service
 * há tres formas diferentes
 * 1 - @Autowired (spring)
 * 2 - @RequiredArgsConstructor (lombok - usei no controller)
 * 3 - fazer o construtor na mão (feito nesse aqui)
 */


import com.crudspring.cadastro_usuario.insfrastructure.entitys.Usuario;
import com.crudspring.cadastro_usuario.insfrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //pra indicar que é a classe de serviço - Ela contém a lógica de negócio da aplicação.
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) { //construtor
        this.repository = repository;
    }


    //metodo salvar
    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario); //salva e fecha a conexao com o banco de dados
    }


    public Usuario buscarUsuarioPorEmail(String email) {      //metodo buscar usuario por email - tem que ir la criar pq o JpaRepository nao tem esse metodo, so busca por ID
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!")
        );
    }


    public void deletarUsuarioPorEmail(String email) {     //metoda deleta por email
        repository.deleteByEmail(email);
    }


    //metodo atualizar - //pega os dados que o usuario passou e os que nao passou pega da entity e joga pro banco de dados
    public void atualizarUsuarioId(Integer id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("usuário não encontrado!"));

        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome()) //usuario.getNome é diferente de nulo ?(esta preenchido), entao prenche o usuario com usuario.getNome, senao, prencher com o nome da entity
                .id(usuarioEntity.getId())
                .build();
        repository.saveAndFlush(usuarioAtualizado);
    }




}