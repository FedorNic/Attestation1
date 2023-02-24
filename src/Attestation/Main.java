/*
13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
14.1 Завести новое животное
14.2 определять животное в правильный класс
14.3 увидеть список команд, которое выполняет животное
14.4 обучить животное новым командам
14.5 Реализовать навигацию по меню
15. ......
 */

package Attestation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void voiceAndPrint(ArrayList<? extends Animal> animals) throws InterruptedException {
        animals.get(0).voice();
        Thread.sleep(500);
        System.out.println(animals.toString().replace("[", "").replace("]", ""));
    }


    public static void getAnimalCommand(ArrayList<? extends Animal> animals, String name) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(name))
                System.out.println("Команда у животного " + name + " - " + animals.get(i).getCommand());
        }
    }

    public static void setAnimalCommand(ArrayList<? extends Animal> animals, String name, String command) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(name))
                animals.get(i).setCommand(command);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Добро пожаловать в тестовый сервис учета животных питомника GeekBrains!");
        Thread.sleep(1500);
        boolean exit = false;
        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Hamster> hamsters = new ArrayList<>();
        ArrayList<Horse> horses = new ArrayList<>();
        ArrayList<Camel> camels = new ArrayList<>();
        ArrayList<Donkey> donkeys = new ArrayList<>();
        while (!exit) {
            //Верхний уровень меню начало
            System.out.println();
            System.out.println("Если Вы хотите внести в систему новое животное – введите цифру «1»");
            System.out.println("Если Вы хотите посмотреть список команд, которые выполняет внесенное в систему животное – введите цифру «2»");
            System.out.println("Если Вы хотите обучить внесенное в систему животное новой команде – введите цифру «3»");
            System.out.println("Завершить программу – введите цифру «0»");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("Программа завершена. Спасибо, что пользуетесь нашими услугами.");
                    exit = true;
                } else if (choice < 0 || choice > 3) {
                    System.out.println("В следующий раз введите правильную цифру =)");
                } else {
                    //Нижний уровень меню начало
                    switch (choice) {
                        case (1):
                            System.out.println("Если Вы хотите внести в систему новую собаку – введите цифру «1»");
                            System.out.println("Если Вы хотите внести в систему новую кошку – введите цифру «2»");
                            System.out.println("Если Вы хотите внести в систему нового хомяка – введите цифру «3»");
                            System.out.println("Если Вы хотите внести в систему новую лошадь – введите цифру «4»");
                            System.out.println("Если Вы хотите внести в систему нового верблюда – введите цифру «5»");
                            System.out.println("Если Вы хотите внести в систему нового осла – введите цифру «6»");
                            System.out.println("Вернуться в предыдущее меню – введите цифру «0»");
                            scanner = new Scanner(System.in);
                            if (scanner.hasNextInt()) {
                                choice = scanner.nextInt();
                                if (choice == 0) {
                                    break;
                                } else if (choice < 0 || choice > 6) {
                                    System.out.println("В следующий раз введите правильную цифру =)");
                                    break;
                                } else {
                                    System.out.println();
                                    Scanner scanner2 = new Scanner(System.in);
                                    System.out.println("Введите имя животного");
                                    String name = scanner2.nextLine();
                                    System.out.println("Введите комманду которую он выпоняет");
                                    String command = scanner2.nextLine();
                                    System.out.println("Введите дату рождения животного в формате 'День.Месяц.Год'");
                                    String dateOfBirth = scanner2.nextLine();
                                    switch (choice) {
                                        case (1):
                                            dogs.add(new Dog(name, command, dateOfBirth));
                                            voiceAndPrint(dogs);
                                            break;
                                        case (2):
                                            cats.add(new Cat(name, command, dateOfBirth));
                                            voiceAndPrint(cats);
                                            break;
                                        case (3):
                                            hamsters.add(new Hamster(name, command, dateOfBirth));
                                            voiceAndPrint(hamsters);
                                            break;
                                        case (4):
                                            horses.add(new Horse(name, command, dateOfBirth));
                                            voiceAndPrint(horses);
                                            break;
                                        case (5):
                                            camels.add(new Camel(name, command, dateOfBirth));
                                            voiceAndPrint(camels);
                                            break;
                                        case (6):
                                            donkeys.add(new Donkey(name, command, dateOfBirth));
                                            voiceAndPrint(donkeys);
                                            break;
                                    }
                                    break;
                                }
                            } else {
                                System.out.println("Необходимо ввести целое число");
                                System.out.println();
                                break;
                            }
                        case (2):
                            System.out.println();
                            Scanner scanner3 = new Scanner(System.in);
                            System.out.println("Введите имя животного");
                            String name = scanner3.nextLine();
                            getAnimalCommand(cats, name);
                            getAnimalCommand(dogs, name);
                            getAnimalCommand(hamsters, name);
                            getAnimalCommand(horses, name);
                            getAnimalCommand(donkeys, name);
                            getAnimalCommand(camels, name);
                            break;
                        case (3):
                            System.out.println();
                            Scanner scanner4 = new Scanner(System.in);
                            System.out.println("Введите имя животного");
                            name = scanner4.nextLine();
                            System.out.println("Введите новую комманду");
                            String command = scanner4.nextLine();
                            setAnimalCommand(dogs, name, command);
                            setAnimalCommand(cats, name, command);
                            setAnimalCommand(hamsters, name, command);
                            setAnimalCommand(horses, name, command);
                            setAnimalCommand(donkeys, name, command);
                            setAnimalCommand(camels, name, command);
                            break;
                    }
                    //Нижний уровень меню конец
                }
            } else {
                System.out.println("Необходимо ввести целое число");
                System.out.println();
            }
        }
        //Верхний уровень меню конец
    }
}
/*
Последний пункт задания я, к сожалению, совсем не понял...
Времени на это не остается.
 */