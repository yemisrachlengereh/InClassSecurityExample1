package me.afua.thymeleafsecdemo.entities;

 import me.afua.thymeleafsecdemo.repositories.RoleRepository;
 import me.afua.thymeleafsecdemo.repositories.UserRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.CommandLineRunner;
 import org.springframework.stereotype.Service;

        import java.util.Arrays;

@Service
public class UserService  {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserData findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }
    public UserData findByUsername(String username){
        return userRepository.findByUsername(username);

    }
    public UserData findByAccountnumber(String username){
        return userRepository.findByUsername(username);
    }

    public UserData findByReason(String username){
        return userRepository.findByUsername(username);
    }
    public UserData findByDepositeamount(String username){
        return userRepository.findByUsername(username);
    }
    public UserData findByWithdrawalamount(String username){
        return userRepository.findByUsername(username);

    }
    public UserData findByTransactionhistory(String username){
        return userRepository.findByUsername(username);

    }

    public UserData findById(String username){
        return userRepository.findByUsername(username);

    }
    public void saveUserData(UserData user) {
        user.addRole (roleRepository.findByRole("STUDENT"));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveAdmin(UserData user) {
        user.addRole (roleRepository.findByRole("TEACHER"));
        user.setEnabled(true);
        userRepository.save(user);
    }
}
