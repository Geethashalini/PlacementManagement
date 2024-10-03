package com.geetha.pms.services;


import com.geetha.pms.entities.User;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for User entity.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return repo.findAll();
    }

    public User save(User user) {
        return repo.save(user);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
        repo.deleteById(id);
    }

	

	public User get(Long id) {
		return repo.findById((long) id).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
	}
}

