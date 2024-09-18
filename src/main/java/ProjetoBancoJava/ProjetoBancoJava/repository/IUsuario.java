package ProjetoBancoJava.ProjetoBancoJava.repository;

import ProjetoBancoJava.ProjetoBancoJava.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

    public Usuario findBynomeOrEmail(String nome, String email);
}

