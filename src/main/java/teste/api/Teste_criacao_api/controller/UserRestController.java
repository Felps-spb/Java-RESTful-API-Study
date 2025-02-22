package teste.api.Teste_criacao_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import teste.api.Teste_criacao_api.models.User;
import teste.api.Teste_criacao_api.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "Find a user by id", description = "Find a user by id")
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(summary = "Create a new user", description = "Create a new user")
    @PostMapping("/CreateUser")
    public ResponseEntity<User> create(@RequestBody User user){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(userService.create(user));
    }
    @Operation(summary = "List all users", description = "List all users")
    @GetMapping("/Search-all")
    public ResponseEntity<List<User>> ListAll(){

        List<User> usuarios = userService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @Operation(summary = "Delete a user by id", description = "Delete a user by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a user by id", description = "Update a user by id")
    @PutMapping("/{id}")
    public ResponseEntity<User> Update(@RequestBody User userToUpdate){
        return ResponseEntity.ok(userService.Update(userToUpdate));
    }
}
