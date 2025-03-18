package com.kipper.desafio_anota_ai.repositories;

import com.kipper.desafio_anota_ai.domain.products.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends MongoRepository<Product, String> {
}
