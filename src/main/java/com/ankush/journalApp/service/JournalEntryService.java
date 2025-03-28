package com.ankush.journalApp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ankush.journalApp.entity.JournalEntry;
import com.ankush.journalApp.entity.User;
import com.ankush.journalApp.repository.JournalEntryRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JournalEntryService {

	@Autowired
	private JournalEntryRepository journalEntryRepository;

	@Autowired
	private UserService userService;

	@Transactional
	public void saveEntry(JournalEntry journalEntry, String userName)
	{
		try
		{
			User user = userService.findByUserName(userName);
			journalEntry.setDate(LocalDateTime.now());
			JournalEntry saved = journalEntryRepository.save(journalEntry);
			user.getJournalEntries().add(saved);
			userService.saveUser(user);	
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new RuntimeException("An error occured while saving the entry", e);
		}
	}

	public void saveEntry(JournalEntry journalEntry)
	{
		journalEntryRepository.save(journalEntry);
	}
	
	
	public List<JournalEntry> getAll() {
		return journalEntryRepository.findAll();
	}

	public Optional<JournalEntry> findById(ObjectId id) {
		return journalEntryRepository.findById(id);
	}

	@Transactional
	public boolean deleteById(ObjectId id, String userName) {
		boolean removed=false;
		try
		{
		User user = userService.findByUserName(userName);
		removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
		if(removed)
		{
			userService.saveUser(user);
			journalEntryRepository.deleteById(id);	
		}
		}
		catch(Exception e)
		{
			log.error("Error", e);
			throw new RuntimeException("An error occured while deleting the entry", e);
		}
		return removed;
	}

	
//	public List<JournalEntry> findByUserName(String userName){
//		
//	}
}
