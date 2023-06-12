package vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vote.entity.data;
import vote.entity.mainTable;
import vote.service.service;

@RestController
@CrossOrigin("*")
public class controller {

	@Autowired
	public service service;

	@GetMapping("/")
	public String a() {
		return "A";
	}

	@PostMapping("/signup")
	public boolean b(@RequestBody mainTable t) {
		return service.signup(t);
	}

	@PostMapping("/login")
	public boolean c(@RequestBody mainTable t) {
		return service.login(t);
	}

	@PostMapping("/addData")
	public boolean d(@RequestBody data t, @RequestParam(name = "name") String name) {
		return service.addData(t, name);
	}

	@GetMapping("/get")
	public List<data> e(@RequestParam(name = "name") String name) {
		return service.get(name);
	}

	@PutMapping("/update")
	public boolean f(@RequestBody data t, @RequestParam(name = "name") String name) {
		return service.update(t, name);
	}

	@DeleteMapping("/delete")
	public boolean g(@RequestParam(name = "name") String name, @RequestParam(name = "id") String id) {
		System.out.printf(name+" "+id);
		return service.delete(name,id);
		
	}

}
