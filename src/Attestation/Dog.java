package Attestation;

public class Dog extends HomeAnimal{

    static int count;
    public Dog(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
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
        return  "Имя собаки " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + dateOfBirth + "\n";
    }
}
