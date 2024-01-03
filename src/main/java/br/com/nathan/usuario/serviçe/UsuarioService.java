package br.com.nathan.usuario.serviçe;

import br.com.nathan.usuario.Model.Usuario;
import br.com.nathan.usuario.repository.UsuarioRepository;
import ch.qos.logback.core.status.StatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuario(){

        return usuarioRepository.findAll();


    }
    public Usuario saveUsuario(Usuario usuarioInput) {
        Integer idade = LocalDate.now().compareTo(usuarioInput.getNascimento());
        if(idade>=18) {
            return usuarioRepository.save(usuarioInput);
        }
        return (null);
    }



    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario updateUsuario(Usuario usuarioInput, Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        if(usuario!= null){
          usuario.setNome(usuarioInput.getNome());
          usuario.setCpf(usuarioInput.getCpf());
          usuario.setEmail(usuarioInput.getEmail());
          usuario.setSenha(usuarioInput.getSenha());
          usuario.setTelefone(usuarioInput.getTelefone());
          usuario.setAtivo(usuarioInput.getAtivo());
          usuario.setNascimento(usuarioInput.getNascimento());
          Integer idade = LocalDate.now().compareTo(usuario.getNascimento());
          if(idade>=18) {
              usuario = usuarioRepository.save(usuario);
          }
          if(idade<18) {
              return(null);
          }
          }

        return(usuario);

    }

    public void deleteUsuario(Long id) {
        Usuario usuario= usuarioRepository.findById(id).get();
        if(usuario!= null){
            usuarioRepository.delete(usuario);
        }

    }
}
