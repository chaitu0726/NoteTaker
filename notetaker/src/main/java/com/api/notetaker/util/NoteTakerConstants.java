package com.api.notetaker.util;

public interface NoteTakerConstants {

	// SQL Queries
	
	String LOGIN_QUERY = "Select * from Login where user_id = ? and passcode = ?";
	String INSERT_NOTE = "Insert into NOTE_DATA(note_title,note_description,login_id) values (?,?,?)";
	String SELECTS_ALL_NOTES_VIA_USER_ID = "Select * from NOTE_DATA where login_id = ?";
	String SELECT_ONE_NOTE ="Select * from NOTE_DATA where note_data_id = ? AND login_id = ?";
	String UPDATE_NOTE_DESCRIPTION = "Update NOTE_DATA SET note_description = ? where note_data_id = ?";
	String DELETE_NOTE ="Delete From NOTE_DATA where note_data_id = ?";
	
	
	//
	String ID ="id";
	String SESSION_TIMEOUT = "Session Timeout";
}
