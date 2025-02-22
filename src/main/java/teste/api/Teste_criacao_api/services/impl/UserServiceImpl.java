package teste.api.Teste_criacao_api.services.impl;
import org.springframework.stereotype.Service;
import teste.api.Teste_criacao_api.models.User;
import teste.api.Teste_criacao_api.repository.UserRepository;
import teste.api.Teste_criacao_api.services.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreate);
    }

    public List<User> findAll(){
        if (userRepository.findAll().isEmpty()){
            throw new NoSuchElementException("No Users found");
        }
        return userRepository.findAll();
    }

    public void deleteById(Long id){
        if (!userRepository.existsById(id)){
            throw new NoSuchElementException("User not found");
        }
        userRepository.deleteById(id);
    }

    public User Update(User userToUpdate){
        if (!userRepository.existsById(userToUpdate.getId())){
            throw new NoSuchElementException("User not found");
        }
        return userRepository.save(userToUpdate);
    }
}
