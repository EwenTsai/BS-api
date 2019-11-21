package tk.ewentsai.contronller;

import tk.ewentsai.pojo.User;
import tk.ewentsai.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/user")
    public User findOneUser(String uname){
        System.out.println("here");
        return userService.findUserByUname(uname);
    }
}
