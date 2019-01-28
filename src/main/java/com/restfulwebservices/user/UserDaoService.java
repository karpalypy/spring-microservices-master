package com.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<UserEntity> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		users.add(new UserEntity(1, "Adam", new Date()));
		users.add(new UserEntity(2, "Eve", new Date()));
		users.add(new UserEntity(3, "Jack", new Date()));
	}

	public List<UserEntity> findAll() {
		return users;
	}

	public UserEntity save(UserEntity user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public UserEntity findOne(int id) {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public UserEntity deleteById(int id) {
		Iterator<UserEntity> iterator = users.iterator();
		while (iterator.hasNext()) {
			UserEntity user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
