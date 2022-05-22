package org.artikon90.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "Item")
public class Item {

    public Item(String item_name, Person item_owner) {
        this.item_name = item_name;
        this.item_owner = item_owner;
    }
    public Item(String item_name) {
        this.item_name = item_name;
    }

    @Id
    @Column(name = "item_id")
    private int item_id;

    @Column(name = "item_name")
    private String item_name;

    @ManyToOne
    @JoinColumn(name = "item_owner", referencedColumnName = "id")
    Person item_owner;

    @Override
    public String toString() {
        return "Item {" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '}';
    }
}
