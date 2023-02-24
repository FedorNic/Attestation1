package Attestation;

public class Cat extends HomeAnimal{

    static int count;
    public Cat(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }

    @Override
    public void voice() {
        System.out.println("Мур!");
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
        return  "Имя кошки " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + dateOfBirth + "\n";
    }
}
