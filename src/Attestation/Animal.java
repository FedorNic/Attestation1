package Attestation;

import java.time.format.DateTimeFormatter;

public abstract class Animal {

    protected String name;
    protected String command;
    protected String dateOfBirth;


    public Animal(String name, String command, String dateOfBirth) {
        this.name = name;
        this.command = command;
        this.dateOfBirth = dateOfBirth;
    }

    protected String getName() {
        return name;
    }

    protected String getCommand() {
        return command;
    }

    protected void setCommand(String command) {
        this.command = command;
    }

    abstract void voice();
}
