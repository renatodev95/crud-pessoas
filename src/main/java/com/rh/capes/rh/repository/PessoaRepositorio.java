package com.rh.capes.rh.repository;

import com.rh.capes.rh.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

}
