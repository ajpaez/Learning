package com.apr.learning.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<CheckoutDetailProduct> checkoutDetailProducts;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //theses method are used to synchronize both sides of
    // the bidirectional association
    public void addCheckoutDetailProduct(CheckoutDetailProduct checkoutDetailProduct) {
        this.checkoutDetailProducts.add(checkoutDetailProduct);
    }

    public void removeCheckoutDetailProduct(CheckoutDetailProduct checkoutDetailProduct) {
        this.checkoutDetailProducts.remove(checkoutDetailProduct);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
