package tech.automationqa.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/{userId}")
    public EntityModel<User> retrieveUser(@PathVariable int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User ID: " + userId);
        }
        EntityModel<User> resource = EntityModel.of(user.get());
        WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        // HATEOAS

        return resource;

    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping(path = "/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }
}
