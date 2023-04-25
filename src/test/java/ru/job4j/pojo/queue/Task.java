package ru.job4j.pojo.queue;

public record Task(Position position,
                   String description,
                   int urgency) {
    }
