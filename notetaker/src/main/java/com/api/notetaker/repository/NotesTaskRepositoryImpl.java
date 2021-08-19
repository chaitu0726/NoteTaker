package com.api.notetaker.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.api.notetaker.model.Login;
import com.api.notetaker.model.NotesPO;

import static com.api.notetaker.util.NoteTakerConstants.*;

@Repository
public class NotesTaskRepositoryImpl implements NotesTaskRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public Login login(Login login) {
		try {
			Login data = this.jdbcTemplate.queryForObject(LOGIN_QUERY, new Object[]{login.getUsername(),login.getPassword()}, new RowMapper<Login>() {
	
				public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Login login = new Login();
					login.setLoginId(rs.getInt(1));
					login.setUsername(rs.getString(2));
					login.setPassword(rs.getString(3));
					return login;
				}
			}); 
			
			return data;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	public int insertNote(NotesPO notesPo) {
		try {
			return this.jdbcTemplate.update(INSERT_NOTE, new Object[] {
				notesPo.getNoteTitle(),
				notesPo.getNoteDescription(),
				notesPo.getLoginId()
			});
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@SuppressWarnings("deprecation")
	public List<NotesPO> selectAllNotesOfUser(int loginId) {
		try {
			return this.jdbcTemplate.query(SELECTS_ALL_NOTES_VIA_USER_ID,new Object[] {loginId},new ResultSetExtractor<List<NotesPO>>() {
				List<NotesPO> notesPoList = new ArrayList<NotesPO>();
				public List<NotesPO> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while(rs.next()) {
						NotesPO notePo = new NotesPO();
						notePo.setNoteDataID(rs.getInt(1));
						notePo.setNoteTitle(rs.getString(2));
						notePo.setNoteDescription(rs.getString(3));
						notePo.setLoginId(rs.getInt(4));
						notesPoList.add(notePo);
					}
					return notesPoList;
				}
				
			});
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public NotesPO selectOneNote(int noteDataId, int loginId) {
		try {
			return this.jdbcTemplate.queryForObject(SELECT_ONE_NOTE, new Object[]{noteDataId , loginId}, new RowMapper<NotesPO>() {
				
				public NotesPO mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					NotesPO notePo = new NotesPO();
					notePo.setNoteDataID(rs.getInt(1));
					notePo.setNoteTitle(rs.getString(2));
					notePo.setNoteDescription(rs.getString(3));
					notePo.setLoginId(rs.getInt(4));
					return notePo;
				}
			}); 
	}catch(Exception e) {
		System.out.println(e.getMessage());
		return null;
	}
}

	public int updateNoteDescription(String Description,int id) {
		try {
			return this.jdbcTemplate.update(UPDATE_NOTE_DESCRIPTION, new Object[] {
				Description,
				id
			});
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int deleteNote(int noteDataId) {
		try {
			return this.jdbcTemplate.update(DELETE_NOTE, new Object[] {
				noteDataId
			});
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

}
