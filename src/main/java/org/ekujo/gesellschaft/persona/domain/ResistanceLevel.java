package org.ekujo.gesellschaft.persona.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ResistanceLevel {
    STRONG("내성"),
    WEAK("취약"),
    NORMAL("보통");

    private final String label;

    ResistanceLevel(String label) {
        this.label = label;
    }

    public static ResistanceLevel fromLabel(String label) {
        for (ResistanceLevel level : values()) {
            if (level.label.equals(label)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Unknown ResistanceLevel label: " + label);
    }

    public static ResistanceLevel fromString(String value) {
        for (ResistanceLevel level : values()) {
            if (level.name().equalsIgnoreCase(value)) {
                return level;
            }
        }
        return fromLabel(value);
    }
}

