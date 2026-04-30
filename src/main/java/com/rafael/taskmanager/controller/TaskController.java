package com.rafael.taskmanager.controller;

import com.rafael.taskmanager.model.Task;
import com.rafael.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        Task task = service.buscarPorId(id);
        return task != null
                ? ResponseEntity.ok(task)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Task criar(@RequestBody Task task) {
        return service.criar(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizar(@PathVariable Long id, @RequestBody Task taskAtualizada) {
        Task task = service.atualizar(id, taskAtualizada);
        return task != null
                ? ResponseEntity.ok(task)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        boolean removido = service.deletar(id);
                return removido
                        ? ResponseEntity.noContent().build()
                        : ResponseEntity.notFound().build();
    }
}

