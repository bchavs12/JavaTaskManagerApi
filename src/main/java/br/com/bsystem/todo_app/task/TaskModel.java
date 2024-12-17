package br.com.bsystem.todo_app.task;

import br.com.bsystem.todo_app.user.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 50,nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String priority;

    private UUID userId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
