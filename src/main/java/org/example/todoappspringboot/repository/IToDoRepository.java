package org.example.todoappspringboot.repository;

import org.example.todoappspringboot.model.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoRepository extends JpaRepository<ToDoModel, Long> {
}
