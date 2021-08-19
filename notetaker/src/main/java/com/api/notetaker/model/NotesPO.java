package com.api.notetaker.model;

public class NotesPO {

	private int noteDataID;
	
	private String noteTitle;
	
	private String noteDescription;
	
	private int loginId;

	public int getNoteDataID() {
		return noteDataID;
	}

	public void setNoteDataID(int noteDataID) {
		this.noteDataID = noteDataID;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteDescription() {
		return noteDescription;
	}

	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	
	
}
