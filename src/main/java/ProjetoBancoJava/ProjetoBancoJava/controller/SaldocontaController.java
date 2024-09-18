package ProjetoBancoJava.ProjetoBancoJava.controller;

import ProjetoBancoJava.ProjetoBancoJava.Model.SaldoConta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ProjetoBancoJava.ProjetoBancoJava.service.SaldoContaService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/saldoconta")
public class SaldocontaController {

    private final SaldoContaService saldoContaService;

    public SaldocontaController(SaldoContaService saldoContaService) {
        this.saldoContaService = saldoContaService;
    }

    @GetMapping
    public ResponseEntity<List<SaldoConta>> listarSaldoContas() {
        List<SaldoConta> saldoContas = saldoContaService.listarSaldoContas();
        return ResponseEntity.status(200).body(saldoContas);
    }

    @PostMapping
    public ResponseEntity<SaldoConta> criarSaldoConta(@Valid @RequestBody SaldoConta saldoConta) {
        return ResponseEntity.status(201).body(saldoContaService.criarSaldoConta(saldoConta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaldoConta> atualizarSaldoConta(
            @PathVariable Integer id, @Valid @RequestBody SaldoConta saldoConta) {
        SaldoConta saldoContaAtualizado = saldoContaService.atualizarSaldoConta(id, saldoConta);
        return ResponseEntity.status(200).body(saldoContaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSaldoConta(@PathVariable Integer id) {
        saldoContaService.excluirSaldoConta(id);
        return ResponseEntity.status(204).build(); // Nenhum conteúdo é retornado no caso de exclusão
    }
}
