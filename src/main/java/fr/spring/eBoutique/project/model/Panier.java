package fr.spring.eBoutique.project.model;

import fr.spring.eBoutique.project.tools.BaseEntity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Entity
public class Panier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ElementCollection
    @CollectionTable(name = "order_item_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "panier")
    private Map<Produit, Integer> myMap = new HashMap<>();

    public Panier() {
        super();
    }

    public Panier(Long id, Map<Produit, Integer> myMap) {
        super();
        this.id = id;
        this.myMap = myMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Produit, Integer> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<Produit, Integer> myMap) {
        this.myMap = myMap;
    }

    @Override
    public String toString() {
        return "Panier [id=" + id + ", myMap=" + myMap + "]";
    }


}
