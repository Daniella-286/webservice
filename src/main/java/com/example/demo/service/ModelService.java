package com.example.demo.service;

import com.example.demo.model.Model;
import com.example.demo.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Optional<Model> getModelById(Long id) {
        return modelRepository.findById(id);
    }

    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    public void updateModel(Long id, Model updatedModel) {
        Optional<Model> existingModel = modelRepository.findById(id);
        existingModel.ifPresent(m -> {
            m.setModelName(updatedModel.getModelName());
            modelRepository.save(m);
        });
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }
}
