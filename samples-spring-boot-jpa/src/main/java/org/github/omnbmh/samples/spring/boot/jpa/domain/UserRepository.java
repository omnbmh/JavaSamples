package org.github.omnbmh.samples.spring.boot.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/8/9 上午10:43
 */
public interface UserRepository extends CrudRepository<User, Long> {

//  User findByUserName(String userName);

//  User findByUserName(String userName, Pageable pageable);

//  User findByUserNameOrEmail(String username, String email);

//  User findFirstByOrderByLastnameAsc();

//  User findTopByOrderByAgeDesc();

//  Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
//
//  List<User> findFirst10ByLastname(String lastname, Sort sort);
//
//  List<User> findTop10ByLastname(String lastname, Pageable pageable);
//
//  @Modifying
//  @Query("update User u set u.userName = ?1 where c.id = ?2")
//  int modifyByIdAndUserId(String  userName, Long id);
//
//  @Transactional
//  @Modifying
//  @Query("delete from User where id = ?1")
//  void deleteByUserId(Long id);
//
//  @Transactional(timeout = 10)
//  @Query("select u from User u where u.emailAddress = ?1")
//  User findByEmailAddress(String emailAddress);
}
