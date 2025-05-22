package org.ekujo.gesellschaft.skill.domain;

public enum AttackType {
    SLASH("참격"),
    PIERCE("관통"),
    BLUNT("타격");

    private final String label;

    AttackType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static AttackType fromLabel(String label) {
        for (AttackType type : AttackType.values()) {
            if (type.label.equals(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + label);
    }
}
