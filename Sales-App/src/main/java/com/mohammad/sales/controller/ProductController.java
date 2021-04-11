package com.mohammad.sales.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mohammad.sales.model.Product;
import com.mohammad.sales.service.ProductService;

@RestController
@CrossOrigin
//Products Management
public class ProductController {
	// Define Service Layer
	@Autowired
	ProductService productrepo;

	// Fetch products and view it.
	@GetMapping("/fetch")
	public List<Product> getproducts() {
		return productrepo.findAll();
	}

	// Create new product And View it
	@PostMapping("/creat")
	public Product creatProduct(@RequestBody Product product) {
		productrepo.save(product);
		return product;
	}

	// Update existing product.
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		List<Product> productlist = productrepo.findAll();
		boolean updated = false;

		// Make sure that the entrance product already exists and is not a new
		for (int i = 0; i < productlist.size(); i++) {
			if (productlist.get(i).getId() == product.getId()) {
				productrepo.save(product);
				updated = true;
			}
		}

		if (updated) {
			return product;
		} else
			return null;

	}

}
