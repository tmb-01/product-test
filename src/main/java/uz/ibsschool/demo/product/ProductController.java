package uz.ibsschool.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/for-developer/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> get() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        Optional<Product> productById = productRepository.findById(id);
        if (productById.isPresent()) {
            return productById.get();
        }
        return null;
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

}
