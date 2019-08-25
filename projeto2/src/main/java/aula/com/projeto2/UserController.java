package aula.com.projeto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUser(){
        System.out.println("Entrou no getUser");
        List<User> users = userRepository.findAll();
        System.out.println(users);
        return users;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user){
        return userRepository.save(user);
    }
}
