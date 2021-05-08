package dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dataAccess.abstracts.UserActivitationDao;
import entities.UserActivitation;

public class InMemoryUserActivitationDao implements UserActivitationDao{

	private ArrayList<UserActivitation> inMemoryUserActivationList;
	public InMemoryUserActivitationDao() {
	this.inMemoryUserActivationList=new ArrayList<UserActivitation>();
	}
	@Override
	public void add(UserActivitation entity) {
		this.inMemoryUserActivationList.add(entity);
		
	}

	@Override
	public void update(UserActivitation entity) {
		this.inMemoryUserActivationList.set(
				this.inMemoryUserActivationList.indexOf(entity),
				entity);
		
	}

	@Override
	public void delete(UserActivitation entity) {
		this.inMemoryUserActivationList.remove(entity);
		
	}

	@Override
	public UserActivitation get(Predicate<UserActivitation> predicate) {
		UserActivitation userActivation=this.inMemoryUserActivationList.stream().filter(predicate).findFirst().orElse(null);
		  
		  return userActivation;
	}

	@Override
	public List<UserActivitation> getAll() {
		  List<UserActivitation> usersActivations=this.inMemoryUserActivationList.stream().collect(Collectors.toList());
		   return usersActivations;
	}

	@Override
	public List<UserActivitation> getAll(Predicate<UserActivitation> predicate) {
		return this.inMemoryUserActivationList.stream().filter(predicate).collect(Collectors.toList());
	}

}
