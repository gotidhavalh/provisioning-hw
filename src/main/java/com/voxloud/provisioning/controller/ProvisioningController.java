package com.voxloud.provisioning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voxloud.provisioning.service.ProvisioningServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class ProvisioningController {

	@Autowired
	private ProvisioningServiceImpl provisioningServiceImpl;

	@GetMapping(value = "/provisioning/{macAddress}")
	public ResponseEntity<?> getConfigurationFile(@PathVariable("macAddress") String macAddress) {

		String configFile = provisioningServiceImpl.getProvisioningFile(macAddress);
		if (configFile == null || configFile.isEmpty())
			return new ResponseEntity<>("Provided MacAddress Not Found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(configFile.getBytes(), HttpStatus.OK);
	}
}