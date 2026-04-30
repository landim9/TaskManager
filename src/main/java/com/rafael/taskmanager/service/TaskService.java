package com.rafael.taskmanager.service;

import com.rafael.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    public List<Task> listar() {
        return tasks;
    }

    public Task buscarPorId(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task criar(Task task) {
        task.setId(proximoId.getAndIncrement());
        tasks.add(task);
        return task;
    }

    public Task atualizar(Long id, Task taskAtualizada) {
        Task task = buscarPorId(id);

        if (task == null) {
            return null;
        }

        task.setTitulo(taskAtualizada.getTitulo());
        task.setDescricao(taskAtualizada.getDescricao());
        task.setStatus(taskAtualizada.getStatus());

        return task;
    }

    public boolean deletar(Long id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }
}