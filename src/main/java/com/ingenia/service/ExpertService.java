package com.ingenia.service;

import com.ingenia.model.Expert;

import java.util.List;

public interface ExpertService {

    // consultas y filtros

    public List<Expert> getAllExperts();

    public Expert getExpert(Long id);

    public List<Expert> filterByNameContains(String name);

    // crear

    public Expert createExpert(Expert expert);

    // actualizar

    public Expert updateExpert(Long id, Expert expert);

    // eliminar

    public boolean deleteExpert(Long id);
}
