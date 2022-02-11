package com.diego.seguradoraapi.domain.service;

import com.diego.seguradoraapi.domain.model.ApoliceModel;
import com.diego.seguradoraapi.domain.repository.ApoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ApoliceService {

    @Autowired
    private ApoliceRepository apoliceRepository;

    public ApoliceService(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    @Transactional
    public ApoliceModel save(ApoliceModel apoliceModel) {
        return apoliceRepository.save(apoliceModel);
    }

    public List<ApoliceModel> findAll() {
        return apoliceRepository.findAll();
    }

    public Optional<ApoliceModel> findByNumeroApolice(long numeroApolice) {
        return apoliceRepository.findById(numeroApolice);
    }

    @Transactional
    public void delete(ApoliceModel apoliceModel) {apoliceRepository.delete(apoliceModel);

    }
}
