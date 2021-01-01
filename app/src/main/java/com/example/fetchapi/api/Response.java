package com.example.fetchapi.api;

public class Response {
    private String message;
    private int permission;

    public Response(String message, int role) {
        this.message = message;
        this.permission = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRole() {
        return permission;
    }

    public void setRole(int role) {
        this.permission = role;
    }
}

