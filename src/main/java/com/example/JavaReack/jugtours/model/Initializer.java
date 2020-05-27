package com.example.JavaReack.jugtours.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final GroupRepository groupRepository;

    public Initializer(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Denver JUG", "New York JUG").
                forEach(g -> groupRepository.save(new Group(g)));

        Group djug = groupRepository.findByName("Denver JUG");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        groupRepository.save(djug);
        groupRepository.findAll().forEach(System.out::println);
    }
}
