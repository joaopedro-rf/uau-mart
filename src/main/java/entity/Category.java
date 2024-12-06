package entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(name, category.name) && Objects.equals(productList, category.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, productList);
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Category(Long categoryId, List<Product> productList, String name) {
        this.categoryId = categoryId;
        this.productList = productList;
        this.name = name;
    }
    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
