package com.rh.capes.rh.utils;

import com.rh.capes.rh.domain.Pessoa;
import com.rh.capes.rh.repository.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
@Transactional
public class DummyData {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    @PostConstruct
    public void savePessoa() {
        Pessoa p1 = new Pessoa("Joao");
        p1.setDataNascimento(LocalDate.of(1990, 3, 15));
        p1.setEmail("joao@gmail.com");
        Pessoa p2 = new Pessoa("Maria");
        p2.setDataNascimento(LocalDate.of(1990, 1, 1));
        p2.setEmail("maria@gmail.com");

        pessoaRepositorio.save(p1);
        pessoaRepositorio.save(p2);
    }
}
