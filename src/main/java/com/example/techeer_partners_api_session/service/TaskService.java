package com.example.techeer_partners_api_session.service;

import com.example.techeer_partners_api_session.dto.TaskRequestDto;
import com.example.techeer_partners_api_session.entity.Task;
import com.example.techeer_partners_api_session.repository.TaskRepository;
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

        // 할일을 생성하는 기능을 만들어놨지만 이 상태로는 프론트엔드가 기능을 쓸 수 없음
        // -> Controller를 통해 외부에서 접근
    }

}
