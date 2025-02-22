package teste.api.Teste_criacao_api.services;
import org.springframework.stereotype.Service;
import teste.api.Teste_criacao_api.models.User;


public interface UserService {

     User findById(Long id);
     User create(User userToCreate);

}
