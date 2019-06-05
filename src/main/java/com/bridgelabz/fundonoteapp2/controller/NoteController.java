package com.bridgelabz.fundonoteapp2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

	@PostMapping(value = "/note/{token}")
	public Note createNote(@PathVariable String token,@RequestBody Note note, HttpServletRequest request) {
//		 return noteService.noteCreate(note,request);
		return noteService.createNote(token,note);//request.getHeader("token"), note);
	}

	@PutMapping(value = "/note/{token}")
	public Note updateNote(@PathVariable String token,@RequestBody Note note, HttpServletRequest request) {

		return noteService.updateNote(token,note);//request.getHeader("token"), note);
	}

	@DeleteMapping(value = "/note/{token}")
	public void deleteNote(@PathVariable String token,@RequestBody Note note, HttpServletRequest request) {
		System.out.println("I am token at delete method :" + request.getHeader("token"));
		System.out.println("token:"+token);
		noteService.deleteNote(token,note);//request.getHeader("token"), note);

	}

	@GetMapping(value = "/notes")
	public List<Note> getNote(HttpServletRequest request) {
		System.out.println("I am token at get method :" + request.getHeader("token"));
		return noteService.getNote(request.getHeader("token"));

	}
	@Cacheable(value = "users", key = "#userId")
	@GetMapping("/testRedis/{userId}")
	//@ApiResponse(response = String.class, message = "Test Redis ", code = 200)
	public String testRedis(@ApiParam("userId") @PathVariable String userId) {
	return "Success" + userId;
	}

	//@CachePut(key = "test")
	@Cacheable(value = "users", key = "#userId")
	@PostMapping("/testRedis/{userId}")
	@ApiResponse(response = String.class, message = "Test Redis post", code = 200)
	public String postRedis(@ApiParam("userId") @PathVariable String userId) {
	return "{}";
	}
}