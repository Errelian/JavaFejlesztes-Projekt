package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.ui.security.SecuredCommand;
import org.springframework.security.access.annotation.Secured;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;


@ShellComponent
public class SignInCommand extends SecuredCommand {

    @ShellMethod(key = "sign in privileged", value = "Sign in as admin.")
    public String signInAdmin(String username, String pass) {
        if (username.equals("admin") && pass.equals("admin")) {
            setAuthentication(true);
            return "Signed in.";
        } else {
            setAuthentication(false);
            return "Login failed due to incorrect credentials.";
        }
    }

    @ShellMethodAvailability("isAdmin")
    @ShellMethod(key = "sign out", value = "Sign out.")
    public String signOut() {
        setAuthentication(false);
        return "Signed out, mate.";
    }

    @ShellMethod(key = "describe account", value = "Describes the account.")
    public String describeAccount() {
        if (isAuthentication()) {
            return "Signed in with privileged account admin";
        } else {
            return "You are not signed in.";
        }
    }

}
