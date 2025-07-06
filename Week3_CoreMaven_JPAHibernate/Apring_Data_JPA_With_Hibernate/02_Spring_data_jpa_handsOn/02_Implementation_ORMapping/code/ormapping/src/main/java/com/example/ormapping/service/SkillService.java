package com.example.ormapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ormapping.model.Skill;
import com.example.ormapping.repository.SkillRepository;
import jakarta.transaction.Transactional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public Skill get(int id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Skill skill) {
        skillRepository.save(skill);
    }
}
