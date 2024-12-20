package com.example.demo.Servises;


import com.example.demo.Repository.TaskRepository;
import com.example.demo.models.Tasak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {

    @Autowired
    private TaskRepository tasakRepository;

    // Récupérer toutes les tâches
    public List<Tasak> getAllTasaks() {
        return tasakRepository.findAll();
    }

    // Récupérer une tâche par ID
    public Optional<Tasak> getTasakById(Long id) {
        return tasakRepository.findById(id);
    }

    // Ajouter une nouvelle tâche
    public Tasak addTasak(Tasak tasak) {
        return tasakRepository.save(tasak);
    }

    // Mettre à jour une tâche
    public Tasak updateTasak(Long id, Tasak tasakDetails) {
        return tasakRepository.findById(id).map(tasak -> {
            tasak.setTask(tasakDetails.getTask());
            tasak.setCompleted(tasakDetails.isCompleted());
            return tasakRepository.save(tasak);
        }).orElseThrow(() -> new RuntimeException("Tasak non trouvée"));
    }

    // Supprimer une tâche
    public void deleteTasak(Long id) {
        tasakRepository.deleteById(id);
    }
}



