package com.bridgelabz.fundonoteapp2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundonoteapp2.model.Label;
import com.bridgelabz.fundonoteapp2.service.NoteService;

@RestController
@RequestMapping
public class LabelController {

	@Autowired
	private NoteService noteService;

	@PostMapping(value = "/label")
	public Label createLabel(@RequestBody Label label, HttpServletRequest request) {

		return noteService.createLabel(request.getHeader("token"), label);
	}

	@PutMapping(value = "/label")
	public Label updateLabel(@RequestBody Label label, HttpServletRequest request) {

		return noteService.updateLabel(request.getHeader("token"), label);
	}

	@DeleteMapping(value = "/label")
	public void deleteLabel(@RequestBody Label label, HttpServletRequest request) {
		System.out.println("I am token at delete method :" + request.getHeader("token"));
		noteService.deleteLabel(request.getHeader("token"), label);

	}

	@GetMapping(value = "/label")
	public List<Label> getLabel(HttpServletRequest request) {
		System.out.println("I am token at get method :" + request.getHeader("token"));
		return noteService.getLabel(request.getHeader("token"));

	}
}
