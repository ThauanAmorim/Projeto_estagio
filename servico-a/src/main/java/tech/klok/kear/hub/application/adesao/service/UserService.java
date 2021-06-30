package tech.klok.kear.hub.application.adesao.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.klok.kear.hub.domain.adesao.model.UserModel;
import tech.klok.kear.hub.infrastructure.persistence.repository.user.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllusers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id) throws Exception {
        Optional<UserModel> optionaluser = userRepository.findById(id);
        if(optionaluser == null) throw new Exception("user não encontrado com esse ID");

        return optionaluser.get();
    }

    public UserModel getByUsername(String username) throws Exception {
        Optional<UserModel> optionaluser = userRepository.findByUsername(username);
        if(optionaluser == null) throw new Exception("user não encontrado com esse username");

        return optionaluser.get();
    }

    public UserModel salvar(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public String delete(Long id) throws Exception {
        try {
            UserModel user = getUserById(id);
            userRepository.delete(user);
            return "User deletado com sucesso";
        } catch (Exception e) {
            throw e;
        }
    }
}
