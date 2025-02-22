package teste.api.Teste_criacao_api.services;
import org.springframework.stereotype.Service;
import teste.api.Teste_criacao_api.models.User;

import java.util.List;


public interface UserService {

     User findById(Long id);
     User create(User userToCreate);
     List<User> findAll();
     void deleteById(Long id);
     User Update(User userToUpdate);
}
