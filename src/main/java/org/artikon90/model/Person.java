package org.artikon90.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "Person")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "item_owner")
    List<Item> items;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
