package com.crudspring.cadastro_usuario.insfrastructure.repository;

import com.crudspring.cadastro_usuario.insfrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//acessa o banco

//vai extender JpaRepository - passando a tabela(Usuario) e o tipo de ID
//todos os métodos básicos para CRUD
/*findAll() → lista todos
findById(id) → busca por ID
save(obj) → insere ou atualiza
deleteById(id) → deleta pelo ID
count() → conta registros
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { //integer é por causa do id no usuario

    Optional<Usuario> findByEmail(String email);   //optional evita o nupointerException, é obgd a criar uma excecao ou alternativa caso o email nao exista

    @Transactional
        //notacao - caso dê algum erro nao podera deletar
    void deleteByEmail(String email);


}
