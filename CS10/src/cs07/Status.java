package cs07;

public enum Status {
    READY("ready"),
    WAIT("waiting"),
    RUN("running"),
    END("terminated");

    private final String message;

    Status(String message){
        this.message = message;
    }
    protected String getMessage(){
        return this.message;
    }
}
