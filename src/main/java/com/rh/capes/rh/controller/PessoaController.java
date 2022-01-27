package com.rh.capes.rh.controller;

import com.rh.capes.rh.domain.Pessoa;
import com.rh.capes.rh.repository.PessoaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String getPessoaForm(Model model) {
        model.addAttribute("listaPessoas", repositorio.findAll());
        return "rh/pessoas/nova";
    }

    @PostMapping("/rh/pessoas/nova")
    public String postPessoaForm(Pessoa pessoa, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/rh/pessoas/nova";
        }
        repositorio.save(pessoa);
        return "redirect:/rh/pessoas";
    }
}
