package com.bridgelabz.fundonoteapp2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.fundonoteapp2.model.Label;
import com.bridgelabz.fundonoteapp2.model.Note;

public interface NoteService {

	Note updateNote(String header, Note note);

	Note createNote(String token, Note note);
	
	
	String deleteNote( int noteId);
	
	Label updateLabel(String header, Label label);

	Label createLabel(String header, Label label);

	boolean deleteLabel(String header, Label label);

	List<Note> getNote(String token);

	List<Label> getLabel(String token);

	//String deleteNote(int noteId, String token);

}