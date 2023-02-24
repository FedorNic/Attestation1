package Attestation;

public class Donkey extends BaggageAnimal{

    static int count;
    public Donkey(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }

    @Override
    public void voice() {
        System.out.println("Иииа!");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getCommand() {
        return super.getCommand();
    }

    @Override
    public void setCommand(String command) {
        super.setCommand(command);
    }

    @Override
    public String toString() {
        return  "Имя осла " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + dateOfBirth + "\n";
    }
}

