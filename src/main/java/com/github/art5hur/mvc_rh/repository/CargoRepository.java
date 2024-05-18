package com.github.art5hur.mvc_rh.repository;

import com.github.art5hur.mvc_rh.model.Cargo;
import com.github.art5hur.mvc_rh.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
