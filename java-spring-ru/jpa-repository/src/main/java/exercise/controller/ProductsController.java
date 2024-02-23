package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping
    public List<Product> index(
            @RequestParam(value = "min", required = false) Integer min,
            @RequestParam(value = "max", required = false) Integer max
    ) {
        if (min == null && max == null) {
            return productRepository.findAll();
        }
        return min == null || max == null ?
                min == null ? productRepository.findAllByPriceLessThanOrderByPriceAsc(max)
                        : productRepository.findAllByPriceGreaterThanOrderByPriceAsc(min)
                : productRepository.findAllByPriceBetweenOrderByPriceAsc(min, max);
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
