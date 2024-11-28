package com.example.techeer_partners_api_session.service;

import com.example.techeer_partners_api_session.dto.TaskRequestDto;
import com.example.techeer_partners_api_session.entity.Task;
import com.example.techeer_partners_api_session.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(TaskRequestDto dto) {
        Task task = new Task(dto.getTitle(),dto.getIsDone()); // task 객체 생성
        //DB에 저장
        taskRepository.save(task);

    }

    public void updateTask(Long id, TaskRequestDto dto) {
        Task task = taskRepository.findById(id).orElse(null);
        task.update(dto.getTitle(), dto.getIsDone());
        taskRepository.save(task);

    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        taskRepository.delete(task);
    }

}
