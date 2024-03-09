import repository.PersonRepository;
import service.PersonService;
import utils.TableUtils;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static PersonService personService =
            new PersonService(new PersonRepository());

    public static void main(String[] args) {

        System.out.println("These are all the person in the repo: ");
        personService.getAllPerson().forEach(
                System.out::println
        );
        System.out.println("II. These are all the person in the repo: ");
        personService.getAllPerson().forEach(
                System.out::println
        );
          class main {
            private static PersonService personService =
                    new PersonService(new PersonRepository());

            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                int option;

                List<String> mainMenu = new ArrayList<>(List.of("Add New Person ", "Show Person Information", "Search", "Exit"));
                do {
                    TableUtils.renderMenu(mainMenu, "Person Management System");
                    System.out.println("Enter your option : ");
                    option = input.nextInt();

                    switch (option) {
                        case 2: {
                            int showOption;
                            List<String> showMenu = new ArrayList<>(List.of(
                                    "Show Original Order",
                                    "Show Descending Order (ID)",
                                    "Show Descending order (name) ",
                                    "Exit"));
                            do {


                                TableUtils.renderMenu(showMenu, "Show Person Information");
                                showOption = input.nextInt();
                                switch (showOption) {
                                    case 1:
                                        TableUtils.renderObjectToTable(personService.getAllPerson());
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        System.out.println("Invalid option");
                                }
                            }while (showOption!=showMenu.size());
                        }


                        break;
                        case 3:
                            System.out.println("Search Person Information");
                            break;
                        case 4:
                            System.out.println("Exit from the program!!! ");
                            break;
                        default:
                            System.out.println("Invalid Option!!!!!! ");
                            break;
                    }
                } while (option != 4);
            }
        }
    }
}