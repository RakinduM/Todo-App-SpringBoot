package org.example.todoappspringboot.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "todo")
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column
    private String Status;

}
