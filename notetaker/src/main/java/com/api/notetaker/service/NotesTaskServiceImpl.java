package com.api.notetaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.notetaker.model.Login;
import com.api.notetaker.model.NotesPO;
import com.api.notetaker.repository.NotesTaskRepository;

@Service
public class NotesTaskServiceImpl implements NotesTaskService {

	@Autowired
	NotesTaskRepository notesTaskRepository;
	
	public boolean login(Login login) {
		Login data = this.notesTaskRepository.login(login);
		return data != null;
	}

	public boolean insertNote(NotesPO notesPo) {
		int data = this.notesTaskRepository.insertNote(notesPo);
		return data != 0;
	}

	public List<NotesPO> selectAllNotesOfUser(int loginId) {
		return this.notesTaskRepository.selectAllNotesOfUser(loginId);
	}

	public NotesPO selectOneNote(int noteDataId, int loginId) {
		return this.notesTaskRepository.selectOneNote(noteDataId, loginId);
	}

	public boolean updateNoteDescription(String description,int id) {
		int data = this.notesTaskRepository.updateNoteDescription(description,id);
		return data != 0;
	}

	public boolean deleteNote(int noteDataId) {
		int data = this.notesTaskRepository.deleteNote(noteDataId);
		return data != 0;
	}

}
