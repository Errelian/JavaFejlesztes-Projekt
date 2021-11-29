package com.epam.training.ticketservice.ui.security;

import org.springframework.shell.Availability;

public abstract class SecuredCommand {
    public static void setAuthentication(boolean authentication) {
        SecuredCommand.authentication = authentication;
    }

    public static boolean isAuthentication() {
        return authentication;
    }

    private static boolean authentication = false;

    public Availability isAdmin() {
        if (authentication) {
            return Availability.available();
        }
        return Availability.unavailable("You are not signed in");
    }
}
