package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> index() {
        var tasks = productRepository.findAll();

        return tasks.stream()
                .map(t -> productMapper.map(t))
                .toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO show(@PathVariable Long id) {
        var task = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
        return productMapper.map(task);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO productCreateDTO) {
        var product = productMapper.map(productCreateDTO);
        productRepository.save(product);
        return productMapper.map(product);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        var product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
        productMapper.update(productUpdateDTO, product);
        productRepository.save(product);
        return productMapper.map(product);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    // END
}
