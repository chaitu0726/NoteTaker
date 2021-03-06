package com.api.notetaker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.notetaker.model.Login;
import com.api.notetaker.model.NotesPO;
import com.api.notetaker.service.NotesTaskService;
import com.api.notetaker.util.SessionHandling;
import static com.api.notetaker.util.NoteTakerConstants.*;
@RestController
@CrossOrigin(origins = {"*"})
public class NotesTaskController {
	
	@Autowired
	NotesTaskService notesTaskService;
	
	@Autowired
	SessionHandling sessionHandling;
	
	 @GetMapping(value="/")
     public String showLoginPage(){
        return "login";
     }

	
	@PostMapping(value = "/login")
	public String login(@RequestBody Login login,HttpSession session) {
		boolean isValidUser =  this.notesTaskService.login(login);
		if(isValidUser) {
			sessionHandling.setSession(login.getUsername(), session);
			return "Login Successful";
		}
		
		return "Invalid Username Or Password";
	}
	
	@PostMapping(value="/insert")
	public String insertNote(@RequestBody NotesPO notePo) {
		return this.notesTaskService.insertNote(notePo)?"Inserted Successfully" : "Something Went Wrong";
	}
	
	@GetMapping(value="/note")
	public NotesPO selectNote(@RequestParam String noteDataId, @RequestParam String loginId) {
		
		int noteId = Integer.parseInt(noteDataId);
		int id = Integer.parseInt(loginId);
		return this.notesTaskService.selectOneNote(noteId, id);
	}
	
	@GetMapping(value="/notes/{id}")
	public List<NotesPO> selectAllNotes(@PathVariable String id){
		int loginId = Integer.parseInt(id);
		return this.notesTaskService.selectAllNotesOfUser(loginId);
	}
	
	@PutMapping(value="/update/{id}")
	public String updateDesription(@PathVariable(value = "id")String id,@RequestParam String description) {
		return this.notesTaskService.updateNoteDescription(description,Integer.parseInt(id)) ? "Updated Successfully" : "Something Went Wrong";
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteNote(@PathVariable(value = "id")String id) {
		return this.notesTaskService.deleteNote(Integer.parseInt(id)) ? "Deleted Successfully" : "Something Went Wrong";
	}
	
	@GetMapping("/checkSession")
	public String isSessionValid() {
		return SESSION_TIMEOUT.equals(this.sessionHandling.getSession()) ? SESSION_TIMEOUT : "SESSION ACTIVE";
	}
	
	@GetMapping("/logout")
	public String logout(){
		return this.sessionHandling.logout() ? "Logout Successfully" : "Something Went Wrong";
	}
	
//	@GetMapping("/currentSession")
//	public boolean isCurrentSeesionActive() {
//		return this.sessionHandling.checkCurrentSession();
//	}
}
