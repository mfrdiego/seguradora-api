package com.diego.seguradoraapi.domain.repository;


import com.diego.seguradoraapi.domain.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, String> {
}
