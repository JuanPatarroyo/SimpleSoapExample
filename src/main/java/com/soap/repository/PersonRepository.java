/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.repository;

import com.javatechie.spring.soap.api.loaneligibility.Detail;
import com.javatechie.spring.soap.api.loaneligibility.Person;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 * @author jpatarroyo
 */
@Component
public class PersonRepository {

    private static final Map<String, Person> people = new HashMap<>();

    @PostConstruct
    public void initData() {
        Person human = new Person();
        human.setName("Juanes");
        human.setAge(25);
        human.setEmail("juanes@correo.com");
        human.setType(Detail.HUMAN);

        Person alien = new Person();
        alien.setName("ET");
        alien.setAge(999);
        alien.setEmail("et.callhome@correo.com");
        alien.setType(Detail.ALIEN);

        Person robot = new Person();
        robot.setName("Wall-E");
        robot.setAge(100);
        robot.setEmail("eeevaaa@correo.com");
        robot.setType(Detail.ROBOT);

        people.put(human.getName(), human);
        people.put(alien.getName(), alien);
        people.put(robot.getName(), robot);
    }

    public Person findPerson(String name) {
        Assert.notNull(name, "The person's name must not be null");
        return people.get(name);
    }
}
