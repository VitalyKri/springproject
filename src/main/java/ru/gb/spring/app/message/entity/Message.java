package ru.gb.spring.app.message.entity;

import lombok.*;

@Getter
@Setter
@Builder // создает для нас ещё 1 класс с паттерном Builder для более удобного создания объекта
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer id;
    private String body;
    private String to;
    private String from;
}
