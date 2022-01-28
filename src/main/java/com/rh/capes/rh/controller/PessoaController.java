package com.rh.capes.rh.controller;

import com.rh.capes.rh.domain.Pessoa;
import com.rh.capes.rh.repository.PessoaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public String novaPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
        return "rh/pessoas/form";
    }

    @GetMapping("/rh/pessoas/{id}")
    private String alterarPessoa(@PathVariable Long id, Model model) {
        Optional<Pessoa> pessoaOptional = repositorio.findById(id);
        validaPessoaExistenteNoBanco(pessoaOptional);
        model.addAttribute("pessoa", pessoaOptional.get());
        return "rh/pessoas/form";
    }

    @PostMapping("/rh/pessoas/salvar")
    public String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
        repositorio.save(pessoa);
        return "redirect:/rh/pessoas";
    }

    @GetMapping("/rh/pessoas/excluir/{id}")
    public String deletarPessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoaOptional = repositorio.findById(id);
        validaPessoaExistenteNoBanco(pessoaOptional);
        repositorio.delete(pessoaOptional.get());
        return "redirect:/rh/pessoas";
    }

    private void validaPessoaExistenteNoBanco(Optional<Pessoa> pessoaOptional) {
        if (pessoaOptional.isEmpty()) {
            throw new IllegalArgumentException("Pessoa inválida.");
        }
    }
}
