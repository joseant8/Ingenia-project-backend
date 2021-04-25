package com.ingenia.service.impl;

import com.ingenia.dao.ExpertDAO;
import com.ingenia.model.Expert;
import com.ingenia.service.ExpertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Expert> getAllExpertsPaging(Pageable paging) {
        return getAllExpertsPaging(paging);
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
    public Expert createExpert(Expert expert) {
        return expertDAO.createExpert(expert);
    }

    @Override
    public Expert updateExpert(Long id, Expert expert) {
        return expertDAO.updateExpert(id, expert);
    }

    @Override
    public boolean deleteExpert(Long id) {
        return expertDAO.deleteExpert(id);
    }
}
