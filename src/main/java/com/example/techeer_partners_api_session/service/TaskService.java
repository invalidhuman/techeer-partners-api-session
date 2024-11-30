package com.example.techeer_partners_api_session.service;

import com.example.techeer_partners_api_session.dto.TaskRequestDto;
import com.example.techeer_partners_api_session.dto.TaskResponseDto;
import com.example.techeer_partners_api_session.entity.Task;
import com.example.techeer_partners_api_session.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<TaskResponseDto> getAllTasks() { // 전달할 dto가 없으니 매개변수도 필요없다.

        List<Task> tasks = taskRepository.findAll();

        return tasks.stream().map(Task::toDto).toList();
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

    public List<TaskResponseDto> getTasksByIsDone(Boolean isDone) {
        List<Task> tasks;
        if (isDone == true)
            tasks = taskRepository.findByIsDone(true);
        else
            tasks = taskRepository.findByIsDone(false);

        return tasks.stream().map(Task::toDto).toList();
    }

}
