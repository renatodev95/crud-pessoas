package com.rh.capes.rh.controller;

import com.rh.capes.rh.domain.Pessoa;
import com.rh.capes.rh.repository.PessoaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PessoaController {

    private final PessoaRepositorio repositorio;

    public PessoaController(PessoaRepositorio pessoaRepositorio) {
        this.repositorio = pessoaRepositorio;
    }

    @GetMapping("/rh/pessoas")
    public String pessoas(Model model) {
        model.addAttribute("listaPessoas", repositorio.findAll());
        return "rh/pessoas/index";
    }

    @GetMapping("/rh/pessoas/nova")
    public String novaPessoa(@ModelAttribute("pessoa")Pessoa pessoa) {
        return "rh/pessoas/form";
    }


}
