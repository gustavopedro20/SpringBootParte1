package br.com.alura.forum.controller;

import java.util.List;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista(String nomeCurso) {
        if (nomeCurso == null) {
            return TopicoDTO.converter(topicoRepository.findAll());
        } else {
            return TopicoDTO.converter(topicoRepository.findByCursoNome(nomeCurso));
        }
    }

}