package com.ashish.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// **** 1st way using different endpoints
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Harley", "Davidson"));
	}

	// **** 2nd way using params (RequestParameter Versioning)
	@GetMapping(value = "person/param", params = "version=1")
	public PersonV1 personPV1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(value = "person/param", params = "version=2")
	public PersonV2 personPV2() {
		return new PersonV2(new Name("Harley", "Davidson"));
	}

	// **** 3rd way using headers
	@GetMapping(value = "person/header", headers = "X-API-VERSION=1")
	public PersonV1 personHV1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(value = "person/header", headers = "X-API-VERSION=2")
	public PersonV2 personHV2() {
		return new PersonV2(new Name("Harley", "Davidson"));
	}

	// **** 3rd way using producers
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Bob Marley");
	}

	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Harley", "Davidson"));
	}

}
