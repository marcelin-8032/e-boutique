package fr.spring.eBoutique.project.model;

import fr.spring.eBoutique.project.tools.BaseEntity;

import java.util.HashMap;
import java.util.Map;

public class Panier extends BaseEntity {

    private Long id;
    private Map<Produit, Integer> myMap = new HashMap<Produit, Integer>();

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
