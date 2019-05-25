package com.bridgelabz.fundonoteapp2.service;

import java.util.List;

import com.bridgelabz.fundonoteapp2.model.Label;
import com.bridgelabz.fundonoteapp2.model.Note;

public interface NoteService {

	Note updateNote(String header, Note note);

	Note createNote(String header, Note note);

	boolean deleteNote(String token, Note note);

	Label updateLabel(String header, Label label);

	Label createLabel(String header, Label label);

	boolean deleteLabel(String header, Label label);

	List<Note> getNote(String token);

	List<Label> getLabel(String token);

}