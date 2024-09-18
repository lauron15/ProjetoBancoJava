package ProjetoBancoJava.ProjetoBancoJava.service;

import ProjetoBancoJava.ProjetoBancoJava.Model.Usuario;
import org.springframework.stereotype.Service;
import ProjetoBancoJava.ProjetoBancoJava.repository.IUsuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuario() {
        return repository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario editarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = repository.findById(usuario.getId());

        if (usuarioExistente.isPresent()) {
            return repository.save(usuario);
        } else {
            throw new RuntimeException("Usuário com o ID " + usuario.getId() + " não encontrado.");
        }
    }

    public Boolean excluirUsuario(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Usuário com o ID " + id + " não encontrado.");
        }
    }

    public Boolean validarSenha(Usuario usuario) {
        Optional<Usuario> usuarioExistente = repository.findById(usuario.getId());

        if (usuarioExistente.isPresent()) {
            String senha = usuarioExistente.get().getSenha();
            return usuario.getSenha().equals(senha);
        }
        return false; // Usuário não encontrado ou senha incorreta
    }
}
