package ProjetoBancoJava.ProjetoBancoJava.repository;

import ProjetoBancoJava.ProjetoBancoJava.Model.SaldoConta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaldoConta extends JpaRepository<SaldoConta, Integer> {

    public SaldoConta findByTipoDeConta(String tipoDeConta);

}
