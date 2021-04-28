package com.ingenia.service.impl;

import com.ingenia.dao.ExpertDAO;
import com.ingenia.model.Expert;
import com.ingenia.payload.request.ExpertEditRequest;
import com.ingenia.service.ExpertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {

    private ExpertDAO expertDAO;

    public ExpertServiceImpl(ExpertDAO expertDAO) {
        this.expertDAO = expertDAO;
    }

    @Override
    public List<Expert> getAllExperts() {
        return expertDAO.getAllExperts();
    }

    @Override
    public Expert getExpert(Long id) {
        return expertDAO.getExpert(id);
    }

    @Override
    public List<Expert> filterByNameContains(String name) {
        return expertDAO.filterByNameContains(name);
    }

    @Override
    public List<Expert> filterByState(String state) {
        return expertDAO.filterByState(state);
    }

    @Override
    public List<Expert> filterByTag(String nameTag) {
        return expertDAO.filterByTag(nameTag);
    }

    @Override
    public List<Expert> filterByPunctuation(Integer puntuacion) {
        return expertDAO.filterByPunctuation(puntuacion);
    }

    @Override
    public List<Expert> getAllExpertsOrdered(String order) {
        return expertDAO.getAllExpertsOrdered(order);
    }

    @Override
    public Expert createExpert(Expert expert) {
        return expertDAO.createExpert(expert);
    }

    @Override
    public Expert updateExpert(Long id, ExpertEditRequest expertUpdated) {
        return expertDAO.updateExpert(id, expertUpdated);
    }

    @Override
    public boolean deleteExpert(Long id) {
        return expertDAO.deleteExpert(id);
    }
}
