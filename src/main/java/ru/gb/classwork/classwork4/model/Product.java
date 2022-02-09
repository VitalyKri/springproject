package ru.gb.classwork.classwork4.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    int id;

    String name;

    double price;


}
