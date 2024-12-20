package com.example.demo.Controllers;

import com.example.demo.Servises.TaskServices;
import com.example.demo.models.Tasak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasaks")
public class TasakController {

    @Autowired
    private TaskServices tasakService;

    // Endpoint pour récupérer toutes les tâches
    @GetMapping
    public List<Tasak> getAllTasaks() {
        return tasakService.getAllTasaks();
    }

    // Endpoint pour récupérer une tâche par ID
    @GetMapping("/{id}")
    public Optional<Tasak> getTasakById(@PathVariable Long id) {
        return tasakService.getTasakById(id);
    }

    // Endpoint pour ajouter une nouvelle tâche
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tasak addTasak(@RequestBody Tasak tasak) {
        return tasakService.addTasak(tasak);
    }

    // Endpoint pour mettre à jour une tâche
    @PutMapping("/{id}")
    public Tasak updateTasak(@PathVariable Long id, @RequestBody Tasak tasakDetails) {
        return tasakService.updateTasak(id, tasakDetails);
    }

    // Endpoint pour supprimer une tâche
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTasak(@PathVariable Long id) {
        tasakService.deleteTasak(id);
    }
}

