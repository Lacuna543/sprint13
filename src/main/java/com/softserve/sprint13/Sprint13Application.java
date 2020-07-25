package com.softserve.sprint13;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.User;
import com.softserve.sprint13.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.ConstraintViolationException;

@SpringBootApplication
public class Sprint13Application implements CommandLineRunner {
    private final ProgressService progressService;
    private final MarathonService marathonService;
    private final UserService userService;
    private final TaskService taskService;
    private final SprintService sprintService;

    public Sprint13Application(ProgressService progressService, MarathonService marathonService, UserService userService, TaskService taskService, SprintService sprintService) {
        this.progressService = progressService;
        this.marathonService = marathonService;
        this.userService = userService;
        this.taskService = taskService;
        this.sprintService = sprintService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Sprint13Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("=======   application started   ========");

        int mentorsNumber = 3;
        int studentsNumber = 10;
        int marathonNumber = 3;
        createSeveralUsers(mentorsNumber, User.Role.MENTOR);
        createSeveralUsers(studentsNumber, User.Role.TRAINEE);
        createSeveralMarathons(marathonNumber);
        showAllMentors();
        showAllStudents();
//    showAllMarathons();
    }

    private void showAllMarathons() {
        System.out.println("All marathons list:");
        System.out.println(marathonService.getAll());
        System.out.println("----------------------------");
    }

    private void createSeveralMarathons(int marathonNumber) {
        Marathon marathon = null;
        for (int i = 1; i < marathonNumber; i++) {
            try {
                marathon = new Marathon();
                marathon.setTitle("JOM" + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            marathonService.createOrUpdate(marathon);
        }
    }

    private void showAllMentors() {
        System.out.println("All mentors list:");
        System.out.println(userService.getAllByRole(User.Role.MENTOR.toString()));
        System.out.println("----------------------------");
    }

    private void showAllStudents() {
        System.out.println("All students list:");
        System.out.println(userService.getAllByRole(User.Role.TRAINEE.toString()));
        System.out.println("----------------------------");
    }

    private void createSeveralUsers(int usersNumber, User.Role role) {
        User user1 = new User();
        for (int i = 1; i < usersNumber; i++) {
            try {
                user1 = new User();
                user1.setEmail(role.toString().toLowerCase() + "Email" + i + "@gmail.com");
                user1.setFirstName(role.toString().toLowerCase() + "Name" + i);
                user1.setLastName(role.toString().toLowerCase() + "LastName" + i);
                user1.setPassword("password" + i);
                user1.setRole(role);
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
            }
            userService.createOrUpdateUser(user1);
        }
    }
}

