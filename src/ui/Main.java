package ui;

import java.util.Scanner;
import model.Club;

public class Main {

    //Relationships
    private Club club;
    
    //Atributes
    private Scanner sc;

    //Builder
    public Main(){
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int option = 0;
        System.out.println("Welcome to the Club manager");
        main.newClub();
        System.out.println("Club succesfully created.");
        System.out.println("Initializing menu...");
        do{
            main.showMenu();
            option = main.sc.nextInt();
            main.sc.nextLine();
            main.executeOperation(option);
        }
        while(option != 0);
    }

    public void showMenu(){
        System.out.print("\n***********  Menu  ***********\n" +
                         "(1) Add a new player to a team. \n" +
                         "(2) Add a new trainer to a team. \n" +
                         "(3) Show the info of the teams. \n" +
                         "(4) Fire a player. \n" +
                         "(5) Fire a principal trainer. \n" +
                         "(6) Fire an assistant trainer. \n" +
                         "(7) Show employees. \n" +
                         "(8) Show dressing rooms. \n" +
                         "(9) Show office sector. \n" +
                         "(0) End the program. \n"
                        );
    }

    public void executeOperation(int option){
        switch(option){
            case 1:
                newPlayer();
            break;
            case 2:
                newTrainer();
            break;
            case 3:
                showTeams();
            break;
            case 4:
                firePlayer();
            break;
            case 5:
                firePrincipal();
            break;
            case 6:
                fireAssistant();
            break;
            case 7:
                showEmployees();
            break;
            case 8:
                showDressingRooms();
            break;
            case 9:
                showOfficeSector();
            break;
        }
    }

    public void newClub(){
        System.out.print("\n To create a new club, fill all the fields:\n");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Nit: ");
        String nit = sc.nextLine();
        System.out.print("Foundation date (DD/MM/YYYY): ");
        String foundationDate = sc.nextLine();
        club = new Club(name, nit, foundationDate);
    }

    public void newPlayer(){
        String name = "";
        String id = "";
        double salary = 0;
        String number = "";
        int goals = 0;
        double averageMark = 0;
        int optionRole = 0;
        String position = "";
        System.out.print("\n Select the team where is going to be add the player: \n");
        System.out.print("(1) Team A \n" +
                         "(2) Team B \n");
        int team = sc.nextInt();
        sc.nextLine();
        if(!(club.teamPlayersHasSpace(team))){
            System.out.println("The team hasn't more space to add players");
        } else{
            System.out.println("Fill all the fields:");
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("ID: ");
            id = sc.nextLine();
            System.out.print("Salary: ");
            salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Number on T-Shirt: ");
            number = sc.nextLine();
            System.out.print("Goals: ");
            goals = sc.nextInt();
            sc.nextLine();
            System.out.print("Average Mark: ");
            averageMark = sc.nextDouble();
            sc.nextLine();
            System.out.println("Select the position of the player: ");
            System.out.print(" (1) Goalie \n (2) Defender \n (3) Midfield \n (4) Forward \n");
            optionRole = sc.nextInt();
            sc.nextLine();
            switch(optionRole){
                case 1:
                    position = "GOALIE";
                break;
                case 2:
                    position = "DEFENDER";
                break;
                case 3:
                    position = "MIDFIELD";
                break;
                case 4:
                    position = "FORWARD";
                break;
            }
            club.addPlayerToTeam(team, name, id, salary, number, goals, averageMark, position);
        }
    }

    public void newTrainer(){
        String name = "";
        String id = "";
        double salary = 0;
        int experienceYears = 0;
        int carreerTeams = 0;
        int carreerChampionships = 0;
        int proOption = 0;
        boolean proPlayer = false;
        System.out.print("\n Select the team where is going to be add the trainer: \n");
        System.out.print("(1) Team A \n" +
                         "(2) Team B \n");
        int team = sc.nextInt();
        sc.nextLine();
        System.out.println("Select the type of trainer that is going to be add: ");
        System.out.print("(1) Principal Trainer \n" +
                         "(2) Assitant Trainer \n");
        int typeOfTrainer = sc.nextInt();
        sc.nextLine();
        switch(typeOfTrainer){
            case 1:
                if(club.teamHasPrincipalTrainer(team)){
                    System.out.println("The team already has principal trainer.");
                } else{
                    System.out.println("Fill all the fields: ");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("ID: ");
                    id = sc.nextLine();
                    System.out.print("Salary: ");
                    salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Experience Years: ");
                    experienceYears = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Carreer Teams: ");
                    carreerTeams = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Carreer Championships: ");
                    carreerChampionships = sc.nextInt();
                    sc.nextLine();
                    club.addPrincipalTrainerToTeam(team, name, id, salary, experienceYears, carreerTeams, carreerChampionships);
                }
            break;
            case 2:
                if(!(club.teamTrainersHasSpace(team))){
                    System.out.println("The team doesn't have more space for trainer assistants.");
                } else{
                    System.out.println("Fill all the fields: ");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("ID: ");
                    id = sc.nextLine();
                    System.out.print("Salary: ");
                    salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Experience Years: ");
                    experienceYears = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Was a professional player (1) Yes / (0) No");
                    proOption = sc.nextInt();
                    sc.nextLine();
                    switch(proOption){
                        case 0:
                            proPlayer = false;
                        break;
                        case 1:
                            proPlayer = true;
                        break;
                    }
                    club.addTrainerAssitantToTeam(team, name, id, salary, experienceYears, proPlayer);
                }
        }
    }

    public void showTeams(){
        System.out.print(club.showTeam(1));
        System.out.print(club.showTeam(2));
    }

    public void showEmployees(){
        System.out.println(club.showEmployees());
    }

    public void firePlayer(){
        System.out.println("Select the team where is the player to fire:");
        System.out.print(" (1) Team A \n (2) Team B \n");
        int team = sc.nextInt();
        sc.nextLine();
        System.out.println("Select the player that is going to be fired: ");
        System.out.print(club.showIndexPlayers(team));
        int index = sc.nextInt();
        sc.nextLine();
        club.firePlayer(team, index-1);
    }

    public void firePrincipal(){
        System.out.println("Select the team where is the principal trainer to fire: ");
        System.out.print(" (1) Team A \n (2) Team B \n");
        int team = sc.nextInt();
        sc.nextLine();
        club.firePrincipal(team);
    }

    public void fireAssistant(){
        System.out.println("Select the team where is the principal trainer to fire: ");
        System.out.print(" (1) Team A \n (2) Team B \n");
        int team = sc.nextInt();
        sc.nextLine();
        System.out.println("Select the assistant trainer that is going to be fired: ");
        System.out.print(club.showIndexAssistant(team));
        int index = sc.nextInt();
        sc.nextLine();
        club.fireAssitant(team, index-1);
    }

    public void showDressingRooms(){
        System.out.print(club.showDressingRoomA());
        System.out.println("");
        System.out.print(club.showDressingRoomB());
    }

    public void showOfficeSector(){
        System.out.print(club.showOfficeSector());
    }
}
