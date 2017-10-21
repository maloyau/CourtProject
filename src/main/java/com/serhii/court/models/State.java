package com.serhii.court.models;

public enum State {
    PREPARATORY("Подготовка"),
    CONSIDERATION_OF_THE_MERITS("Рассмотрение сути дела"),
    LITIGATION("Судебный процесс"),
    ANNOUNCEMENT_OF_THE_DECISION("Решение");

    private final String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
