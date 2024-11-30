package com.example.techeer_partners_api_session.controller;

import com.example.techeer_partners_api_session.dto.ApiResponseDto;
import com.example.techeer_partners_api_session.dto.TaskRequestDto;
import com.example.techeer_partners_api_session.dto.TaskResponseDto;
import com.example.techeer_partners_api_session.entity.Task;
import com.example.techeer_partners_api_session.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController // Rest api 기반 controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // 1. 할 일 생성
    @PostMapping
    public ResponseEntity<Map<String, String>> createTask (@RequestBody TaskRequestDto dto) {
        taskService.createTask(dto);
        // post요청같은 경우에는 응답을 할 필요는 없지만 잘 받았다는 걸알려주기 위해서 저장
        Map<String,String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "할 일이 성공적으로 생성되었습니다.");
        return ResponseEntity.status(201).body(response);
    }

    // 2. 할 일 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String,String>> updateTask (@PathVariable Long id, @RequestBody TaskRequestDto dto) { //URL 경로의 일부를 메서드 매개변수로 매핑
        taskService.updateTask(id, dto);
        Map<String, String> response = new HashMap<>();
        response.put("status","success");
        response.put("message","할 일이 수정되었습니다.");

        return ResponseEntity.status(200).body(response);
    }

    // 3. 할 일 삭제
    @DeleteMapping("{id}")
    public ResponseEntity deleteTask (@PathVariable Long id) {
        taskService.deleteTask(id);

        Map<String, String> response = new HashMap<>();
        response.put("status","success");
        response.put("message","할 일이 삭제되었습니다.");
        return ResponseEntity.status(200).body(response);
    }

    // 모든 할 일 조회
    @GetMapping
    public ResponseEntity<ApiResponseDto<List<TaskResponseDto>>> getAllTasks () {
        List<TaskResponseDto> tasks = taskService.getAllTasks();

        ApiResponseDto<List<TaskResponseDto>> response = new ApiResponseDto(
                "success",
                "모든 게시글이 조회되었습니다.",
                tasks
        );

        return ResponseEntity.status(200).body(response);
    }
}