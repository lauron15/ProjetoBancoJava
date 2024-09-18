package ProjetoBancoJava.ProjetoBancoJava.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "saldoconta")
public class SaldoConta {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Integer id;

@Column(name = "saldo_conta")
private BigDecimal saldo;

@NotBlank(message = "O tipo de conta é obrigatório!")
@Column(name = "tipoDeConta")
private String tipoDeConta;

}
