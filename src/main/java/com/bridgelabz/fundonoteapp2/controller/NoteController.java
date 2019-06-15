package com.bridgelabz.fundonoteapp2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundonoteapp2.model.Note;

import com.bridgelabz.fundonoteapp2.service.NoteService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping(value = "/createNote/{token}")
	public ResponseEntity<Note> createNote(@PathVariable String token, @RequestBody Note note,HttpServletRequest request) {

		return new ResponseEntity<Note>(noteService.createNote(token, note), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateNote/{token}")
	public ResponseEntity<Note> updateNote(@PathVariable String token, @RequestBody Note note,
			HttpServletRequest request) {

		return new ResponseEntity<Note>(noteService.updateNote(token, note), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteNote/{noteId}")
	public ResponseEntity<String> deleteNote(@PathVariable int noteId, HttpServletRequest request) {
		System.out.println("I am token at delete method :" + request.getHeader("token"));
		return new ResponseEntity<String>(noteService.deleteNote(noteId), HttpStatus.CREATED);

	}

	@GetMapping(value = "/getNotes/{token}")
	public List<Note> getNote(@PathVariable String token, HttpServletRequest request) {
		System.out.println("I am token at get method :" + request.getHeader("token"));
		return noteService.getNote(token);// request.getHeader("token"));

	}

	@Cacheable(value = "users", key = "#userId")
	@GetMapping("/testRedis/{userId}")
	// @ApiResponse(response = String.class, message = "Test Redis ", code = 200)
	public String testRedis(@ApiParam("userId") @PathVariable String userId) {
		return "Success" + userId;
	}

	// @CachePut(key = "test")
	@Cacheable(value = "users", key = "#userId")
	@PostMapping("/testRedis/{userId}")
	@ApiResponse(response = String.class, message = "Test Redis post", code = 200)
	public String postRedis(@ApiParam("userId") @PathVariable String userId) {
		return "{}";
	}
}