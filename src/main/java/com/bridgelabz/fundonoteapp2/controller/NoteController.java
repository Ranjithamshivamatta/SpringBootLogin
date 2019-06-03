package com.bridgelabz.fundonoteapp2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundonoteapp2.model.Note;
import com.bridgelabz.fundonoteapp2.service.NoteService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")	
public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping(value = "/createnote")
	public Note createNote(@RequestBody Note note, HttpServletRequest request) {

		return noteService.createNote(request.getHeader("token"), note);
	}

	@PutMapping(value = "/updatenote")
	public Note updateNote(@RequestBody Note note, HttpServletRequest request) {

		return noteService.updateNote(request.getHeader("token"), note);
	}

	@DeleteMapping(value = "/deletenote")
	public void deleteNote(@RequestBody Note note, HttpServletRequest request) {
		System.out.println("I am token at delete method :" + request.getHeader("token"));
		noteService.deleteNote(request.getHeader("token"), note);

	}

	@GetMapping(value = "/retrievenote")
	public List<Note> getNote(HttpServletRequest request) {
		System.out.println("I am token at get method :" + request.getHeader("token"));
		return noteService.getNote(request.getHeader("token"));

	}

}