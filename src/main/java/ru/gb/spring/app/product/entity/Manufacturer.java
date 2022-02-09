package ru.gb.spring.app.product.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "manufacturer")
@NamedQueries({
        @NamedQuery(name = "Manufacturer.findById",
                query = "select m from Manufacturer m where m.id = :id"),
        @NamedQuery(name = "Manufacturer.findNameById",
                query = "select m.name from Manufacturer m where m.id = :id")
})
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ru.gb.spring.app.product.entity.Product> products;

    public boolean addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }
        return products.add(product);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'';
    }
}
