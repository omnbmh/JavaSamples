package org.github.omnbmh.samples.spring.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created With IntelliJ IDEA CE
 * Desc: Write Something!
 *
 * 2017/8/9 下午3:18
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories(
    basePackages = {"org.github.omnbmh.samples.spring.boot.jpa.domain"}) //设置Repository所在位置
public class SpringBootJpaApplication {

  @Bean
  public Object testBean(PlatformTransactionManager platformTransactionManager) {
    System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
    return new Object();
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBootJpaApplication.class, args);
  }
}
