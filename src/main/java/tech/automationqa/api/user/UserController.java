package tech.automationqa.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.getAllUsers();
    }

    @GetMapping(path = "/users/{userId}")
    public User getUser(@PathVariable int userId) {
        User user = userDaoService.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException("User ID: " + userId);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.addUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping(path = "/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        User user = userDaoService.deleteUser(userId);
        if (user == null) {
            throw new UserNotFoundException("User ID: " + userId);
        }
    }
}
