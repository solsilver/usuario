package br.com.nathan.usuario.controller;

import br.com.nathan.usuario.Model.Usuario;
import br.com.nathan.usuario.serviçe.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarUsuarios() {

        List<Usuario> usuarios = usuarioService.getUsuario();
        return ResponseEntity.ok().body(usuarios);

    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuarioInput) {

        Usuario usuarioOutput = usuarioService.saveUsuario(usuarioInput);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/usuario/{id}").
                buildAndExpand(usuarioOutput.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @RequestMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") Long id) {

        Usuario usuario;
        usuario = usuarioService.getUsuario(id);
        return ResponseEntity.ok().body(usuario);

    }
    // jc é vagabunda
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuarioInput, @PathVariable("id") Long id) {
        Usuario usuarioupdate = usuarioService.updateUsuario(usuarioInput, id);

        return ResponseEntity.ok().body(usuarioupdate);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteUsuario(id);

        return ResponseEntity.ok().build();

    }


}
