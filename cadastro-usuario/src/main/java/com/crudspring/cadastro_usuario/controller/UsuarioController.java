package com.crudspring.cadastro_usuario.controller;

/*
 * precisa injetar a dependencia do repository dentro da classe Service
 * há tres formas diferentes
 * 1 - @Autowired (spring)
 * 2 - @RequiredArgsConstructor (lombok, usei aqui)
 * 3 - fazer o construtor na mão (usei no UsuarioService)
 */

import com.crudspring.cadastro_usuario.business.UsuarioService;
import com.crudspring.cadastro_usuario.insfrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //- gera automaticamente um construtor para a sua classe.
@RestController  // - usado em APIs REST, retorna dados (JSON/XML).
@RequestMapping("/usuario") //- serve para mapear URLs (endereços HTTP) para métodos ou classes em um controller.
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    //gravar dados   - serve para mapear requisições HTTP do tipo POST para um método de um controller REST.
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id, @RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }


}
