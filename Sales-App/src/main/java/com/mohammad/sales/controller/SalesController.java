package com.mohammad.sales.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohammad.sales.model.Log;
import com.mohammad.sales.model.Sales;
import com.mohammad.sales.service.LogService;
import com.mohammad.sales.service.SalesService;

@RestController
@CrossOrigin
//Sales && Logging
public class SalesController {
	// Define Service Layer
	@Autowired
	SalesService salesrepo;

	@Autowired
	LogService logrepo;

	// Fetch all sales operations and view them.
	@GetMapping("/fetchsales")
	public List<Sales> getsales() {
		return salesrepo.findAll();
	}

	// Create new sales with multiple transactions And View it
	@PostMapping("/creatsale")
	public Sales creatSale(@RequestBody Sales sale) {
		salesrepo.save(sale);
		return sale;
	}

	// Edit quantities and prices of the sale.
	@PutMapping("/updatesale")
	public Sales updateSale(@RequestParam("sid") int sid, @RequestParam("quantities") int quantities,
			@RequestParam("prices") int prices) {
		List<Sales> saleslist = salesrepo.findAll();
		boolean updated = false;
		Sales Sale = new Sales();
		// Make sure that the entrance Sale already exists and not new
		for (int i = 0; i < saleslist.size(); i++) {
			if (saleslist.get(i).getId() == sid) {
				Sale = salesrepo.findById(sid).orElse(null);
				Sale.setQuantities(quantities);
				Sale.setTotal(prices);
				salesrepo.save(Sale);
				updated = true;
			}
		}

		if (updated) {
			// log all update operations on sale transactions.
			Log log = new Log();
			log.setClientName(Sale.getClient().getFirstname());
			log.setQty(Sale.getQuantities());
			log.setSeller(Sale.getSeller());
			log.setTotal(Sale.getTotal());
			log.setSale(Sale);
			logrepo.save(log);
			return Sale;
		} else
			return null;

	}

}
