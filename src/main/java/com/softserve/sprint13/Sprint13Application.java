package com.softserve.sprint13;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Sprint;
import com.softserve.sprint13.entity.Task;
import com.softserve.sprint13.entity.User;
import com.softserve.sprint13.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.relation.Role;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.Random;

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
            addUsersToMarathon();
//    showAllMarathons();
            addTaskToSprint();
            addTaskToStudent();
        }

        private void addUsersToMarathon() {
            int userNumber = userService.getAll().size();
            int marathonNumber = marathonService.getAll().size();
            Random randomUserId = new Random();
            Random randomMarathonId = new Random();
            for (int i = 1; i < userNumber; i++) {
                User user = userService.getUserById((long) randomUserId.nextInt(userNumber) + 1);
                Marathon marathon = marathonService
                        .getMarathonById((long) randomMarathonId.nextInt(marathonNumber) + 1);
                userService.addUserToMarathon(user, marathon);
            }
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
            User user1 = null;
            for (int i = 1; i <= usersNumber; i++) {
                try {
                    user1 = new User();
                    user1.setEmail(role.toString().toLowerCase() + "Email" + i + "@gmail.com");
                    user1.setFirstName(role.toString().toLowerCase() + "Name" + i);
                    user1.setLastName(role.toString().toLowerCase() + "LastName" + i);
                    user1.setPassword("password" + i);
                    user1.setRole(role);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                userService.createOrUpdateUser(user1);
            }
        }

        private void addTaskToSprint() {
            Sprint sprint = new Sprint();
            sprint.setFinish(LocalDate.now());
            sprint.setStart_date(LocalDate.now());
            sprint.setTitle("sprint1");
            Sprint sprint1 = sprintService.create(sprint);
            Task task = new Task();
            task.setTitle("task1");
            Task task2 = new Task();
            task2.setTitle("task2");
            Task task3 = new Task();
            task3.setTitle("task2");
            taskService.addTaskToSprint(task, sprint);
            taskService.addTaskToSprint(task2, sprint);
            taskService.addTaskToSprint(task3, sprint);
            Task taskById = taskService.getTaskById((long) 2);
            System.out.println("/////////////////task///////////////////////");
            System.out.println(taskById);

            Marathon marathon = new Marathon();
            marathon.setTitle("marathon1");
            marathonService.createOrUpdate(marathon);
            sprintService.addSprintToMarathon(sprint, marathon);

            Sprint sprint2 = new Sprint();
            sprint2.setTitle("sprint2");
            sprint2.setStart_date(LocalDate.now());
            sprint2.setFinish(LocalDate.now());
            Sprint sprint3 = sprintService.create(sprint2);
            sprintService.addSprintToMarathon(sprint2, marathon);

            Sprint sprint4 = new Sprint();
            sprint4.setTitle("sprint4");
            sprint4.setFinish(LocalDate.now());
            sprint4.setStart_date(LocalDate.now());
            Sprint sprint5 = sprintService.create(sprint4);
            sprintService.addSprintToMarathon(sprint4, marathon);

        }

        private void addTaskToStudent() {
            User user = new User();
            user.setLastName("LASTNAME");
            user.setFirstName("FIRSTNAME");
            user.setEmail("USER@EMAIL.COM");
            user.setRole(User.Role.TRAINEE);
            user.setPassword("PASSWORD");
//    userService.createOrUpdate(user);
//    User userFromDb = userService.createOrUpdate(user);

            Sprint sprint = new Sprint();
            sprint.setTitle("SPRINT");
            sprint.setStart_date(LocalDate.now());
            sprint.setFinish(LocalDate.now());
            Sprint sprintFromDb = sprintService.create(sprint);

            Task task = new Task();
            task.setTitle("TASK");
            task.setSprint(sprintFromDb);
            task.setCreated(LocalDate.now());
            task.setUpdated(LocalDate.now());
            Task taskFromDb = taskService.create(task);
//    progressService.addTaskForStudent(taskFromDb, userFromDb);
        }
    }