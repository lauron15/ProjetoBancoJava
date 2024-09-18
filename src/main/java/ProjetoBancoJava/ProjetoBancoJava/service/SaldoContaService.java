package ProjetoBancoJava.ProjetoBancoJava.service;

import ProjetoBancoJava.ProjetoBancoJava.Model.SaldoConta;
import org.springframework.stereotype.Service;
import ProjetoBancoJava.ProjetoBancoJava.repository.ISaldoConta;

import java.util.List;
import java.util.Optional;

@Service
public class SaldoContaService {

    private final ISaldoConta repository;

    public SaldoContaService(ISaldoConta repository) {
        this.repository = repository;
    }

    public List<SaldoConta> listarSaldoContas() {
        return repository.findAll();
    }

    public SaldoConta criarSaldoConta(SaldoConta saldoConta) {
        return repository.save(saldoConta);
    }

    public SaldoConta atualizarSaldoConta(Integer id, SaldoConta saldoContaAtualizada) {
        Optional<SaldoConta> saldoContaExistente = repository.findById(id);

        if (saldoContaExistente.isPresent()) {
            SaldoConta saldoConta = saldoContaExistente.get();
            // Atualizar os campos da conta existente com os novos valores
            saldoConta.setSaldo(saldoContaAtualizada.getSaldo());  // Exemplo de atualização de campo
            // Adicione outras atualizações conforme necessário
            return repository.save(saldoConta);
        } else {
            // Se não for encontrado, pode-se lançar uma exceção ou retornar null
            throw new RuntimeException("SaldoConta com o ID " + id + " não encontrada.");
        }
    }

    public Boolean excluirSaldoConta(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("SaldoConta com o ID " + id + " não encontrada.");
        }
    }

    public SaldoConta buscarSaldoContaPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("SaldoConta com o ID " + id + " não encontrada."));
    }
}
