package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ciberfarma.model.Registrar;

@Repository
public interface IRegistrarRepository extends JpaRepository<Registrar, Integer> {

}
