package model;

import java.util.ArrayList;

import model.TrainerAssistant;

public class Team {

    //Constants
    public final int MAX_PLAYERS = 25;
    public final int MAX_TRAINERS = 3;
    
    //Atributes
    private String name;
    private int numOfPlayers;
    private int numOfAssistants;

    //Relationships
    private Player[] players;
    private PrincipalTrainer principalTrainer;
    private TrainerAssistant[] assistantsTrainers;
    private ArrayList<LineUp> lineUps;

    //Builder
    public Team(String name){
        this.name = name;
        this.numOfPlayers = 0;
        this.numOfAssistants = 0;
        this.players = new Player[MAX_PLAYERS];
        this.assistantsTrainers = new TrainerAssistant[MAX_TRAINERS];
        this.lineUps = new ArrayList<LineUp>();
    }

    public boolean playersHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_PLAYERS && !space; i++){
            if(players[i] == null){
                space = true;
            }
        }
        return space;
    }

    public boolean trainersHasSpace(){
        boolean space = false;
        for(int i = 0; i<MAX_TRAINERS && !space; i++){
            if(assistantsTrainers[i] == null){
                space = true;
            }
        }
        return space;
    }

    public boolean teamHasPrincipalTrainer(){
        boolean trainer = false;
        if(principalTrainer != null){
            trainer = true;
        }
        return trainer;
    }

    public Player addPlayer(String name, String id, double salary, String number, int goals, double averageMark, String position){
        boolean found = false;
        int index = 0;
        for(int i = 0; i<MAX_PLAYERS && !found; i++){
            if(players[i] == null){
                found = true;
                index = i;
            }
        }
        players[index] = new Player(name, id, salary, number, goals, averageMark, position);
        numOfPlayers++;
        return players[index];
    }

    public PrincipalTrainer addPrincipalTrainer(String name, String id, double salary, int experienceYears, int carreerTeams, int carreerChampionships){
        principalTrainer = new PrincipalTrainer(name, id, salary, experienceYears, carreerTeams, carreerChampionships);
        return principalTrainer;
    }

    public TrainerAssistant addTrainerAssistant(String name, String id, double salary, int experienceYears, boolean proPlayer){
        boolean found = false;
        int index = 0;
        for(int i = 0; i<MAX_TRAINERS && !found; i++){
            if(assistantsTrainers[i] == null){
                found = true;
                index = i;
            }
        }
        assistantsTrainers[index] = new TrainerAssistant(name, id, salary, experienceYears, proPlayer);
        numOfAssistants++;
        return assistantsTrainers[index];
    }

    public String showIndexPlayers(){
        String text = "\n **********  Players  ********** \n";
        int index = 0;
        for(int i = 0; i<MAX_PLAYERS; i++){
            if(players[i] != null){
                index++;
                text += (index) + ". " + players[i].getName() + "\n";
            }
        }
        return text;
    }

    public String showTeam(){
        String text = "\n **********  Team  ********** \n" + 
                      "Name: " + name + "\n";
        return text;
    }

    public String showPlayers(){
        String text = "";
        for(int i = 0; i<MAX_PLAYERS; i++){
            if(players[i] != null){
                text += players[i].showInfo();
            }
        }
        return text;
    }

    public String showPrincipalTrainer(){
        String text = "";
        if(!(teamHasPrincipalTrainer())){
            text = "\n The team hasn't principal trainer \n";
        } else{
            text = principalTrainer.showInfo();
        }
        return text;
    }

    public String showIndexAssistants(){
        String text = "\n **********  Assitants Trainers  ********** \n";
        int index = 0;
        for(int i = 0; i<MAX_TRAINERS; i++){
            if(assistantsTrainers[i] != null){
                index++;
                text += (index) + ". " + assistantsTrainers[i].getName() + "\n";
            }
        }
        return text;
    }

    public String showAssitantTrainers(){
        String text = "";
        for(int i = 0; i<MAX_TRAINERS; i++){
            if(assistantsTrainers[i] != null){
                text += assistantsTrainers[i].showInfo();
            }
        }
        return text;
    }

    public String showAllInfo(){
        String text = showTeam() + showPlayers() + showPrincipalTrainer() + showAssitantTrainers();
        return text;
    }

    public Player firePlayer(int index){
        Player firedPlayer = players[index];
        players[index] = null;
        firedPlayer.fireEmployee();
        numOfPlayers--;
        return firedPlayer;
    }

    public PrincipalTrainer firePrincipal(){
        PrincipalTrainer firedPrincipal = principalTrainer;
        principalTrainer = null;
        firedPrincipal.fireEmployee();
        return firedPrincipal;
    }

    public TrainerAssistant fireAssistant(int index){
        TrainerAssistant firedAssistant = assistantsTrainers[index];
        assistantsTrainers[index] = null;
        firedAssistant.fireEmployee();
        numOfAssistants--;
        return firedAssistant;
    }
}
