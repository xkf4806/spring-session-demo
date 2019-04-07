package com.example.goopal;

import com.example.goopal.domain.Person;
import com.example.goopal.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xinj.x
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisOpsTest {
  @Autowired
  private PersonRepository personRepository;

  @Test
  public void test1() {
    Person person = Person.builder()
            .firstName("Michael")
            .finalName("Jordan")
            .address(Person.Address.builder()
                    .province("Hebei")
                    .city("Shijiazhuang").build())
            .build();
    personRepository.save(person);

    personRepository.findById(person.getId())
            .ifPresent(person1 -> log.info("get person info by redis repository, info: {}", person1));
  }

}
