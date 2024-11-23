package com.example.techeer_partners_api_session.controller;

import com.example.techeer_partners_api_session.dto.TaskRequestDto;
import com.example.techeer_partners_api_session.repository.TaskRepository;
import com.example.techeer_partners_api_session.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController // Rest api 기반 controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createTask (@RequestBody TaskRequestDto dto) {
        taskService.createTask(dto);
        // post요청같은 경우에는 응답을 할 필요는 없지만 잘 받았다는 걸알려주기 위해서 저장
        Map<String,String> response = new HashMap<>();
        response.put("message", "할 일이 성공적으로 생성되었습니다.");
        return ResponseEntity.status(201).body(response);
    }
}
