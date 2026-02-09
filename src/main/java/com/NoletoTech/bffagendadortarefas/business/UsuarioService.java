package com.NoletoTech.bffagendadortarefas.business;

import com.NoletoTech.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.in.LoginDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.NoletoTech.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.NoletoTech.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.NoletoTech.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.NoletoTech.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class UsuarioService {

        private final UsuarioClient Client;



        public UsuarioDTOResponse salvaUsuario (UsuarioDTORequest usuarioDTO){
           return Client.salvaUsuario(usuarioDTO);
        }

        public String loginUsuario(LoginDTORequest usuarioDTO){
            return Client.login(usuarioDTO);
        }


        public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token){
            return Client.buscaPorEmail(email,token);
        }


        public void deletaUsuarioPorEmail(String email,String token){
            Client.deletaPorEmail(email, token);
        }

        public UsuarioDTOResponse atualizarDadosUsuario(String token, UsuarioDTORequest dto){
            return Client.atualizaDadoUsuario(dto, token);
        }

        public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
            return Client.atualizaEndereco(enderecoDTO,idEndereco,token);
        }

        public TelefoneDTOResponse atualizaTelefone (Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
            return Client.atualizaTelefone(telefoneDTO,idTelefone,token);
        }


        public EnderecoDTOResponse cadastraEndereco (String token, EnderecoDTORequest dto){
            return Client.cadastraEndereco(dto, token);
        }


        public TelefoneDTOResponse cadastraTelefone (String token, TelefoneDTORequest dto){

            return Client.cadastraTelefone(dto, token);
        }

    }

