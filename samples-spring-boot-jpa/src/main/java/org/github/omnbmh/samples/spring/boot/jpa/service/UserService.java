package org.github.omnbmh.samples.spring.boot.jpa.service;

import org.github.omnbmh.samples.spring.boot.jpa.domain.User;
import org.github.omnbmh.samples.spring.boot.jpa.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/8/9 下午3:25
 */
@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  //  public UserService(UserRepository userRepository) {
//    this.userRepository = userRepository;
//  }
//  @javax.transaction.Transactional
  public User saveUser(User user) {

    return this.userRepository.save(user);
  }
}
