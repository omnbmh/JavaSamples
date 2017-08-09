package org.github.omnbmh.samples.spring.boot.jpa.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.github.omnbmh.samples.spring.boot.jpa.domain.User;
import org.github.omnbmh.samples.spring.boot.jpa.domain.UserRepository;
import org.github.omnbmh.samples.spring.boot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/8/9 下午3:25
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/add")
  @ResponseBody
  public String save() {
    User user = new User();
    user.setEmail("mming@126.cn");
    user.setNickName("mm");
    user.setPassWord("password");
    user.setRegTime("20170101");
    user.setUserName("M " + System.currentTimeMillis());
    this.userService.saveUser(user);
    return "ok";
  }

  @RequestMapping("/list")
  @ResponseBody
  public List<User> list() {
    Iterable<User> geted = this.userRepository.findAll();
    List<User> list = new ArrayList<User>();
//    geted.forEach(single ->{list.add(single)});

    for (User u : geted) {
      list.add(u);
    }
    return list;
  }

}
