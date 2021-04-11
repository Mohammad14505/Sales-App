package com.mohammad.sales.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohammad.sales.model.Clients;
import com.mohammad.sales.service.ClientService;

@RestController
@CrossOrigin
//Clients Management
public class ClientController {
	// Define Service Layer
	@Autowired
	ClientService clientrepo;

	// Fetch clients and view it
	@GetMapping("/fetchclients")
	public List<Clients> getClients() {
		return clientrepo.findAll();
	}

	// Create new client. And View it
	@PostMapping("/creatclient")
	public Clients creatClient(@RequestBody Clients client) {
		clientrepo.save(client);
		return client;
	}

	// Edit existing client.
	@PutMapping("/updateclient")
	public Clients updateClient(@RequestBody Clients client) {
		List<Clients> clientlist = clientrepo.findAll();
		boolean updated = false;

		// Make sure that the entrance client already exists and is not a new
		for (int i = 0; i < clientlist.size(); i++) {
			if (clientlist.get(i).getId() == client.getId()) {
				clientrepo.save(client);
				updated = true;
			}
		}

		if (updated) {
			return client;
		} else
			return null;

	}

}
