package com.api.notetaker.service;

import java.util.List;

import com.api.notetaker.model.Login;
import com.api.notetaker.model.NotesPO;

public interface NotesTaskService {

public boolean login(Login login);
	
	public boolean insertNote(NotesPO notesPo);
	
	public List<NotesPO> selectAllNotesOfUser(int loginId);
	
	public NotesPO selectOneNote(int noteDataId, int loginId);
	
	public boolean updateNoteDescription(String Description,int id);
	
	public boolean deleteNote(int noteDataId);
}
