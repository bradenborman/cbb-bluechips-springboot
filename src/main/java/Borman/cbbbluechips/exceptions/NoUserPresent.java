package Borman.cbbbluechips.exceptions;

public class NoUserPresent extends RuntimeException {

    private String emailAttempted;

    public NoUserPresent(String emailAttempted) {
        super("EmptyResultDataAccessException: No user for " + emailAttempted);
        this.emailAttempted = emailAttempted;
    }

    public NoUserPresent(String message, String emailAttempted) {
        super(message);
        this.emailAttempted = emailAttempted;
    }

    public String getEmailAttempted() {
        return emailAttempted;
    }
}