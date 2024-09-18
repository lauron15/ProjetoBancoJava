package ProjetoBancoJava.ProjetoBancoJava.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name ="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    @Column(name = "nome", length = 100,nullable = false)
    private String nome;

    @Email(message = "Digite um e-mail válido")
    @NotBlank(message = "O email é obrigatório!")
    @Column(name = "email", length = 100, nullable = false )
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres")
    @Column(name = "senha", columnDefinition = "Text", nullable = false)
    private String senha;

}
