package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Student {
    private int id;
    private String studentname;
    private String password;

    public Student(String studentnamename, String password) {
    }

    public Student addNewStudent(Scanner input) {
        System.out.println("Enter studentname: ");
        studentname = input.nextLine();
        System.out.println("Enter password: ");
        password = input.nextLine();
        return this;
    }
}