package org.github.omnbmh.samples.spring.boot.jpa.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/8/9 上午10:40
 */
@Entity
//@Table(name = "user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  @GenericGenerator(name = "jpa", strategy = "uuid")
  private Long id;
  @Column(nullable = false, unique = true)
  private String userName;
  @Column(nullable = false)
  private String passWord;
  @Column(nullable = false)
  private String email;
  @Column(nullable = true)
  private String nickName;

  // 不映射成字段
//  @Transient
  @Column(nullable = false)
  private String regTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getRegTime() {
    return regTime;
  }

  public void setRegTime(String regTime) {
    this.regTime = regTime;
  }

  public User() {
  }

}
