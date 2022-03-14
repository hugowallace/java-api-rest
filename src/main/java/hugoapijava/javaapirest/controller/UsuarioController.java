package hugoapijava.javaapirest.controller;

import hugoapijava.javaapirest.model.UsuarioModel;
import hugoapijava.javaapirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path = "/api/usuario/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario) {
        return repository.save(usuario);

    }
}
