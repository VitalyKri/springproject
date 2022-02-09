package ru.gb.spring.app.product.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findById",
                query = "select p from Product p where p.id = :id"),
        @NamedQuery(name = "Product.getAll",
                query = "select p from Product p")})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "manufacture_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ru.gb.spring.app.product.entity.Manufacturer manufacturer;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", manufacturer=" + manufacturer.getName() +
                ", carts=" + carts +
                '}';
    }

    @ManyToMany
    @JoinTable(name = "cart_product",joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private Set<ru.gb.spring.app.product.entity.Cart> carts;


}
