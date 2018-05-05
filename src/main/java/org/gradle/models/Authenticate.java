package org.gradle.models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.gradle.demo.Demo;
import org.gradle.scheduling.Scheduler;

/**
 * To abstract the storage access from the business layer using HttpSession
 */
public class Authenticate {

	private final HttpSession context;
	protected static final String CONTEXT_NAME = "users";

	public Authenticate(HttpSession context) {
		this.context = context;
	}

	public boolean authenticate(String username, String password) {

		ArrayList<User> users = new Demo().users;
 
		for (User item: users) {
			if (username.equals(item.getUsername())) {
				context.setAttribute(CONTEXT_NAME, users);
				context.setAttribute("user", item);
				return true;
			}
		}

		return false;

	}

	public Optional<User> getAuthenticatedUser() {

		ArrayList<User> users = new Demo().users;

		for (User item: users) {
			if (context.getAttribute("user").equals(item)) {
				return Optional.of(item);
			}
		}

		return Optional.empty();

		}

	public void logout() {

		context.invalidate();
	}
}
