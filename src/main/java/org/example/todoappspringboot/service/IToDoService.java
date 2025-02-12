package org.example.todoappspringboot.service;

import org.example.todoappspringboot.model.ToDoModel;

import java.util.List;

public interface IToDoService {
    List<ToDoModel> getAllToDoItems();
    ToDoModel getToDoItemById(Long id);
    boolean updateStatus(Long id);
    boolean saveOrUpdateToDoItem(ToDoModel todo);
    boolean deleteToDoItem(Long id);
}
