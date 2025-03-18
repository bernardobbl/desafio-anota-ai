package com.kipper.desafio_anota_ai.domain.category;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

public class Category {
    @Id
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    private String ownerId;



    public Category(CategoryDTO categoryDTO){
        this.title = categoryDTO.title();
        this.description = categoryDTO.description();
        this.ownerId = categoryDTO.ownerId();
    }
    @Override
    public String toString(){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("title", title);
        json.put("description", description);
        json.put("ownerId", ownerId);
        json.put("type", "categoria");

        return json.toString();
    }

    public String deleteToString(){
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("ownerId", this.ownerId);
        json.put("type", "delete-categoria");

        return json.toString();
    }

}
