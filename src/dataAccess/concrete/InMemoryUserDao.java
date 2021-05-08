package dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import dataAccess.abstracts.UserDao;
import entities.User;

public class InMemoryUserDao implements UserDao{

	private ArrayList<User> inMemoryUserList;
	
	public InMemoryUserDao() {
		this.inMemoryUserList=new ArrayList<User>();
	}
	@Override
	public void add(User entity) {

		this.inMemoryUserList.add(entity);
	}

	@Override
	public void update(User entity) {
	
		this.inMemoryUserList.set(
				this.inMemoryUserList.indexOf(entity),
				entity);
	}

	@Override
	public void delete(User entity) {
		
		this.inMemoryUserList.remove(entity);
	}

	@Override
	public User get(Predicate<User> predicate) {
	  User user=this.inMemoryUserList.stream().filter(predicate).findFirst().orElse(null);
	  
	  return user;
	}

	@Override
	public List<User> getAll() {
	   List<User> users=this.inMemoryUserList.stream().collect(Collectors.toList());
	   return users;
	}

	@Override
	public List<User> getAll(Predicate<User> predicate) {
		
		return this.inMemoryUserList.stream().filter(predicate).collect(Collectors.toList());
	}

}
