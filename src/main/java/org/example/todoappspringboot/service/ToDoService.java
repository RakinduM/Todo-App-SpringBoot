package org.example.todoappspringboot.service;

import org.example.todoappspringboot.model.ToDoModel;
import org.example.todoappspringboot.repository.IToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService implements IToDoService {
    @Autowired
    IToDoRepository repo;

    @Override
    public List<ToDoModel> getAllToDoItems() {
        ArrayList<ToDoModel> todoList = new ArrayList<>();
        repo.findAll().forEach(todo -> todoList.add(todo));
        return todoList;
    }

    @Override
    public ToDoModel getToDoItemById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean updateStatus(Long id) {
        ToDoModel todo = getToDoItemById(id);
        todo.setStatus("Completed");
        return saveOrUpdateToDoItem(todo);
    }

    @Override
    public boolean saveOrUpdateToDoItem(ToDoModel todo) {
        ToDoModel updatedObj = repo.save(todo);
        if (getToDoItemById(updatedObj.getId()) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteToDoItem(Long id) {
        repo.deleteById(id);
        if (getToDoItemById(id) == null){
            return true;
        }
        return false;
    }
}
