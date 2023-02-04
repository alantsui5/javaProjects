package com.alanlearn.IphoneDataPlatform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alanlearn.IphoneDataPlatform.bean.Iphone;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("iphones")
public class IphoneController {

	private final List<Iphone> iphoneData = new ArrayList<>();

	@PostConstruct
	private void initData(){
		iphoneData.add(new Iphone("1", "iPhone 14", "A15", 2022, 3279));
		iphoneData.add(new Iphone("2", "iPhone 13", "A15", 2021, 3227));
		iphoneData.add(new Iphone("3", "iPhone 12", "A14", 2020, 2815));
		iphoneData.add(new Iphone("4", "iPhone 11", "A13", 2019,3110));
	}

	// HTTP GET data list Request
	// http://localhost:8080/iphones
	@GetMapping
	public ResponseEntity<List<Iphone>> getIphone(){
		return ResponseEntity.ok(iphoneData);
	}

	// Spring BOOT REST API with Path Variable
	// {id} - URI template variable
	// http://localhost:8080/iphones/1
	@GetMapping("{id}")
	public ResponseEntity<Iphone> getIphone(@PathVariable("id") String iphoneId){

		Optional<Iphone> iphoneOp = iphoneData.stream()
				.filter(p -> p.getId().equals(iphoneId))
				.findFirst();

		if (iphoneOp.isPresent()) {
			Iphone iphone = iphoneOp.get();
			return ResponseEntity.ok().body(iphone);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	// Spring boot REST API with Request Param
	//  http://localhost:8080/iphones/query?name=iPhone14
	@GetMapping("query")
	public ResponseEntity<Iphone> findIphoneByQuery(@RequestParam String id){
		Optional<Iphone> iphoneOp = iphoneData.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst();

		if (iphoneOp.isPresent()) {
			Iphone newIphone = iphoneOp.get();
			return ResponseEntity.ok().body(newIphone);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Spring boot REST API that handles HTTP POST Request - creating new resource
	// @PostMapping and @RequestBody
	@PostMapping("create")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Iphone> createIphone(@RequestBody Iphone iphone){

		boolean isIdDuplicated = iphoneData.stream()
				.anyMatch(p -> p.getId().equals(iphone.getId()));
		if (isIdDuplicated) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}

		Iphone newIphone = new Iphone();
		newIphone.setId(iphone.getId());
		newIphone.setName(iphone.getName());
		newIphone.setSoc(iphone.getSoc());
		newIphone.setReleaseYear(iphone.getReleaseYear());
		newIphone.setBattery(iphone.getBattery());

		iphoneData.add(newIphone);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newIphone.getId())
				.toUri();

		return ResponseEntity.created(location).body(newIphone);
	}

	// Spring boot REST API that handles HTTP PUT Request - updating existing resource
	@PutMapping("{id}/update")
	public ResponseEntity<Iphone> updateIphone(@RequestBody Iphone iphone, @PathVariable("id") String iphoneId){
		Optional<Iphone> iphoneOp = iphoneData.stream()
				.filter(p -> p.getId().equals(iphoneId))
				.findFirst();

		if (iphoneOp.isPresent()) {
			Iphone newIphone = iphoneOp.get();
			newIphone.setId(iphone.getId());
			newIphone.setName(iphone.getName());
			newIphone.setSoc(iphone.getSoc());
			newIphone.setReleaseYear(iphone.getReleaseYear());
			newIphone.setBattery(iphone.getBattery());

			return ResponseEntity.ok().body(newIphone);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteIphone(@PathVariable("id") String iphoneId){
		boolean isRemoved = iphoneData.removeIf(p -> p.getId().equals(iphoneId));

		return isRemoved
				? ResponseEntity.ok().build()
				: ResponseEntity.notFound().build();
	}
}