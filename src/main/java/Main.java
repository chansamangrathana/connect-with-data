import model.Person;
import repository.PersonRepository;
import service.PersonService;
import utils.TableUtils;

import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static PersonService personService =
            new PersonService(new PersonRepository());

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        List<String> mainMenu = new ArrayList<>(List.of("Add New Person", "Show person Information", "Search", "Exit"));
        do {
            TableUtils.renderMenu(mainMenu, "Person Management System");
            System.out.print("Enter your option");
            option = input.nextInt();
            switch (option) {
                case 2: {
                    int showOption;
                    List<String> showMenu = new ArrayList<>(List.of(
                            "Show original",
                            "Show Descending Order(ID) ",
                            "Show Descending order(name)",
                            "Exit"));

                    do {

                        TableUtils.renderMenu(showMenu, "Show Peeson Information");
                        System.out.println("Choose your option");
                        showOption = input.nextInt();
                        switch (showOption) {
                            case 1:
                                TableUtils.renderObjectToTable(personService.getAllPerson());
                                break;
                            case 2:

                                TableUtils.renderObjectToTable(personService.getAllPerson()
                                        .stream()
                                        .sorted(
                                                Comparator.comparingInt(Person::getId).reversed()

                                        )
                                        .toList());

                                break;
                            case 3:

                                break;
                            default:
                                System.out.println("Invalid");

                        }
                    } while (showOption != showMenu.size());
                }
                break;
                case 3:
                    System.out.println("Search person information");
                    break;
                case 4:
                    System.out.println("Exit from the program");
                    break;
                default:
                    System.out.println("Invaild option");

            }


        }while (option!=4);
    }
}