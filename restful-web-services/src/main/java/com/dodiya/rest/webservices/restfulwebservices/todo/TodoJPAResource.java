package com.dodiya.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJPAResource {
	
	
	@Autowired
	private TodoHardodedService todoService;
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		
//		return todoService.findAll();
		
		
		
		return todoJpaRepository.findByUsername(username);
		
	}
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getAllTodos(@PathVariable String username,@PathVariable Long  id){
		
//		return todoService.findById(id);
		return todoJpaRepository.findById(id).get();
		
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long  id,@RequestBody Todo todo){
		
//		Todo updatedTodo=todoService.save(todo);
		
		Todo updatedTodo=todoJpaRepository.save(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		
		
	}
	
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username,@RequestBody Todo todo){
		
//		Todo createdTodo=todoService.save(todo);
		
		todo.setUsername(username);
		
		Todo createdTodo=todoJpaRepository.save(todo);
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
		
	}



	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long  id){
		
//		Todo todo = todoService.deleteById(id);
		todoJpaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
			
			
		
//		return ResponseEntity.notFound().build();
	}

}
