package com.diego.seguradoraapi.domain.repository;

import com.diego.seguradoraapi.domain.model.Apolice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoliceRepository extends JpaRepository<Apolice, Long> {
}
