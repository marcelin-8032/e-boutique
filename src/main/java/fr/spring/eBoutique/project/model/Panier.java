package fr.spring.eBoutique.project.model;

import java.util.HashMap;
import java.util.Map;

public class Panier {

    private Integer id;
    private Map<Produit, Integer> myMap = new HashMap<Produit, Integer>();

    public Panier() {
        super();
    }

    public Panier(Integer id, Map<Produit, Integer> myMap) {
        super();
        this.id = id;
        this.myMap = myMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
