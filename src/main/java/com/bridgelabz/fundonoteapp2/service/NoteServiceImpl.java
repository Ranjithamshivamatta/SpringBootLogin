package com.bridgelabz.fundonoteapp2.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.fundonoteapp2.model.Label;
import com.bridgelabz.fundonoteapp2.model.Note;
import com.bridgelabz.fundonoteapp2.repository.LabelRepository;
import com.bridgelabz.fundonoteapp2.repository.NoteRepository;
import com.bridgelabz.fundonoteapp2.util.Utility;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRep;
	@Autowired
	private LabelRepository labelRep;

	
	

	@Override
	public Note createNote(String token, Note note) {
		int varifiedUserId = Utility.tokenVerification(token);
	System.out.println("note creation :" + varifiedUserId);
		note.setUserId(varifiedUserId);
	LocalDateTime time=LocalDateTime.now();
		note.setCreadtedtime(time);
		return noteRep.save(note);
	}

	@Override
	public Note updateNote(String token, Note note) {
		int varifiedUserId = Utility.tokenVerification(token);
		System.out.println("varifiedUserId :" + varifiedUserId);
		Optional<Note> maybeNote = noteRep.findByUserIdAndNoteId(varifiedUserId, note.getNoteId());
		System.out.println("maybeNote :" + maybeNote);
		Note presentNote = maybeNote.map(existingNote -> {
			System.out.println("noteee here");
			existingNote.setDiscription(
					note.getDiscription() != null ? note.getDiscription() : maybeNote.get().getDiscription());
			existingNote.setTitle(note.getTitle() != null ? note.getTitle() : maybeNote.get().getTitle());
			return existingNote;
		}).orElseThrow(() -> new RuntimeException("Note Not Found"));

		return noteRep.save(presentNote);
	}

	@Override
	public boolean deleteNote(String token, Note note) {
		int varifiedUserId = Utility.tokenVerification(token);
		noteRep.deleteByUserIdAndNoteId(varifiedUserId, note.getNoteId());
		return true;
	}

	@Override
	public List<Note> getNote(String token) {
		int varifiedUserId = Utility.tokenVerification(token);
		System.out.println("i m in fetch :" + varifiedUserId);

		List<Note> notes = (List<Note>) noteRep.findByUserId(varifiedUserId);

		return notes;
	}

	@Override
	public Label createLabel(String token, Label label) {
		int varifiedUserId = Utility.tokenVerification(token);
		System.out.println("label creation :" + varifiedUserId);
		label.setUserId(varifiedUserId);
		return labelRep.save(label);
	}

	@Override
	public Label updateLabel(String token, Label label) {
		int varifiedUserId = Utility.tokenVerification(token);
		System.out.println("varifiedUserId :" + varifiedUserId);
		Optional<Label> maybeLabel = labelRep.findByUserIdAndLabelId(varifiedUserId, label.getLabelId());
		System.out.println("maybeLabel :" + maybeLabel);
		Label presentLabel = maybeLabel.map(existingLabel -> {
			System.out.println("label here");
			existingLabel.setLabelName(
					label.getLabelName() != null ? label.getLabelName() : maybeLabel.get().getLabelName());

			return existingLabel;
		}).orElseThrow(() -> new RuntimeException("Label Not Found"));

		return labelRep.save(presentLabel);
	}

	@Override
	public boolean deleteLabel(String token, Label label) {
		int varifiedUserId = Utility.tokenVerification(token);
		labelRep.deleteByUserIdAndLabelId(varifiedUserId, label.getLabelId());
		return true;
	}

	@Override
	public List<Label> getLabel(String token) {
		int varifiedUserId = Utility.tokenVerification(token);
		System.out.println("i m in fetch :" + varifiedUserId);

		List<Label> labels = labelRep.findByUserId(varifiedUserId);

		return labels;
	}
//
//	@Override
//	
//		public Note noteCreate(Note note, HttpServletRequest request) {
//			String token1 = request.getHeader("token");
//			int id = Utility.tokenVerification(token1);
//			note.setUserId(id);
//			LocalDateTime time=LocalDateTime.now();
//			return noteRep.save(note);
//			

	
	
	
}