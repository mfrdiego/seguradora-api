package com.diego.seguradoraapi.domain.repository;

import com.diego.seguradoraapi.domain.model.ApoliceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoliceRepository extends JpaRepository<ApoliceModel, Long> {
}
