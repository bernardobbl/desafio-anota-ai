package com.kipper.desafio_anota_ai.domain.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor

public class Product {

    @Id
    private String id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String description;
    private String ownerId;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    private Integer price;
    private String category;

    public Product(ProductDTO data){
        this.title = data.title();
        this.description = data.description();
        this.ownerId = data.ownerId();
        this.price = data.price();
        this.category = data.categoryId();


    }

    @Override
    public String toString(){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("title", title);
        json.put("description", description);
        json.put("ownerId", ownerId);
        json.put("price", price);
        json.put("category", category);
        json.put("type", "produto");

        return json.toString();

}
    public String deleteToString(){
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("ownerId", this.ownerId);
        json.put("type", "delete-produto");

        return json.toString();
    }
}
