package com.dmall.product.apis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.dmall.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	private List<Product> products = null;

	public ProductController() throws ParseException {
		this.products = Arrays.asList(
				new Product("d001", "Li Shizhen", formatter.parse("2015-04-23")),
				new Product("d002", "Hua Tuo", formatter.parse("2015-05-12")),
				new Product("d003", "Zhang Zhongjing", formatter.parse("2015-04-27")));
	}

	@GetMapping
	public List<Product> getCommentsByTaskId() {

		return products;
	}

	@RequestMapping(value = "/{doctorId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getDoctorByDoctorId(@PathVariable("doctorId") final String doctorId) {
		Optional<Product> doctor = products.stream().filter(c -> Objects.equals(c.getProdcutId(), doctorId)).findAny();

		return doctor.isPresent() ? doctor.get() : null;
	}
}
