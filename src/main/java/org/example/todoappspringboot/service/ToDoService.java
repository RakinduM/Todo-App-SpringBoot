package org.example.todoappspringboot.service;

import org.example.todoappspringboot.model.ToDoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService implements IToDoService {
    @Override
    public List<ToDoModel> getAllToDoItems() {
        return List.of();
    }

    @Override
    public ToDoModel getToDoItemById(Long id) {
        return null;
    }

    @Override
    public boolean updateStatus(Long id) {
        return false;
    }

    @Override
    public boolean saveOrUpdateToDoItem(ToDoModel todo) {
        return false;
    }

    @Override
    public boolean deleteToDoItem(Long id) {
        return false;
    }
}
