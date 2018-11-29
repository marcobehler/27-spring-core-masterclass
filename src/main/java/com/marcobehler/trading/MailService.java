package com.marcobehler.trading;

public class MailService {

    private final String hostname;
    private final Integer port;
    private final String username;

    public MailService(String hostname, Integer port, String username) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
    }

    public void sendWelcomeEmail(User user) {
        // TODO send the real email
        System.out.println("Sending out welcome email via " + hostname + " " + port + " to : user.getEmail() = " + user.getEmail());;
    }
}
