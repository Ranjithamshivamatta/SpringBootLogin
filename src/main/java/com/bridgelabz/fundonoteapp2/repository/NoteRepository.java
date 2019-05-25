package com.bridgelabz.fundonoteapp2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundonoteapp2.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

	public List<Note> findByUserId(int varifiedUserId);

	public Optional<Note> findByUserIdAndNoteId(int varifiedUserId, int noteid);

	public void deleteByUserIdAndNoteId(int varifiedUserId, int noteId);

	public List<Note> findAll();

}