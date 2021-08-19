package com.api.notetaker.repository;

import java.util.List;

import com.api.notetaker.model.Login;
import com.api.notetaker.model.NotesPO;

public interface NotesTaskRepository {

	public Login login(Login login);
	
	public int insertNote(NotesPO notesPo);
	
	public List<NotesPO> selectAllNotesOfUser(int loginId);
	
	public NotesPO selectOneNote(int noteDataId, int loginId);
	
	public int updateNoteDescription(String Description,int id);
	
	public int deleteNote(int noteDataId);
	
}
