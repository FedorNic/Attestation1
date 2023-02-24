package Attestation;

public class Camel extends BaggageAnimal{

    static int count;
    public Camel(String name, String command, String dateOfBirth) {
        super(name, command, dateOfBirth);
        count++;
    }

    @Override
    public void voice() {
        System.out.println("Тьфу!");
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
        return  "Имя верблюда " + count + " = " + name +
                ", комманда = " + command +
                ", дата рождения = " + dateOfBirth + "\n";
    }
}
