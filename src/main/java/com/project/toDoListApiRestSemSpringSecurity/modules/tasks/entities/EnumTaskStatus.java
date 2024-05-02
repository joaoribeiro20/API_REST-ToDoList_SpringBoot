package com.project.toDoListApiRestSemSpringSecurity.modules.tasks.entities;

import jakarta.persistence.Embeddable;


public enum EnumTaskStatus {
    completed("completed"),
    pending("pending");

    private String filter;

    EnumTaskStatus(String filter) {
        this.filter=filter;
    }

    public static EnumTaskStatus filterStatus(String text) {
        for (EnumTaskStatus status : EnumTaskStatus.values()) {
            if (status.filter.equalsIgnoreCase(text)) {
                return status;
            }
        }
//        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
        return null;
    }
}
