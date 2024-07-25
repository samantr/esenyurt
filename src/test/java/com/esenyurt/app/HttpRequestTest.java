package com.esenyurt.app;
import com.esenyurt.entity.Person;
import com.esenyurt.service.PersonService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonService personService;


    @Before
    public void loginTest()
    {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication =
                new TestingAuthenticationToken("aaa", "123", "ADMIN_USER");
        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);
    }
    @Test
    public void logoutTest()
    {
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
    }
    @Test
    public void personShouldReturnPersonList() throws Exception {

        List<Person> personList = personService.readPersons();
        Assertions.assertThat(personList.size()>0);
    }

    @Test
    public void personCreateTest() throws Exception {

        Person person = new Person();
        person.setName("dddddddd");
        person.setLastName("hhhhhhhh");
        person.setCode("ssppsas");
        Person newPerson = personService.createPerson(person);
        Assertions.assertThat(newPerson.getId() != null);
    }
}
