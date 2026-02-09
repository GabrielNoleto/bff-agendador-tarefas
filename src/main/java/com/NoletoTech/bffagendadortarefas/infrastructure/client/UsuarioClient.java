package com.NoletoTech.bffagendadortarefas.infrastructure.client;


import com.NoletoTech.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.NoletoTech.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.NoletoTech.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaPorEmail(@RequestParam("email") String email, @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
     String login (@RequestBody LoginDTORequest usuarioDTO);

    @DeleteMapping("/{email}")
     Void deletaPorEmail(@PathVariable String email, @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadoUsuario(@RequestBody UsuarioDTORequest dto, @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto, @RequestParam("id") Long id, @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto, @RequestHeader("Authorization") String token);


    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto, @RequestHeader("Authorization") String token);

}
