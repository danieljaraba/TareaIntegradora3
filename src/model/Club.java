package model;

import java.util.ArrayList;

public class Club {

    //Atributes
    private String name;
    private String nit;
    private String foundationDate;
    private String[][] dressingRoomA;
    private String[][] dressingRoomB;

    //Relationships
    private Team teamA;
    private Team teamB;
    private ArrayList<Employee> employees;

    //Builder
    public Club(String name, String nit, String foundationDate){
        this.name = name;
        this.nit = nit;
        this.foundationDate = foundationDate;
        this.dressingRoomA = new String[7][6];
        this.dressingRoomB = new String[7][7];
        this.teamA = new Team("A");
        this.teamB = new Team("B");
        this.employees = new ArrayList<Employee>();
    }

    public boolean teamPlayersHasSpace(int team){
        boolean space = false;
        switch(team){
            case 1:
                space = teamA.playersHasSpace();
            break;
            case 2:
                space = teamB.playersHasSpace();
            break;
        }
        return space;
    }

    public boolean teamTrainersHasSpace(int team){
        boolean space = false;
        switch(team){
            case 1:
                space = teamA.trainersHasSpace();
            break;
            case 2:
                space = teamB.trainersHasSpace();
            break;
        }
        return space;
    }

    public boolean teamHasPrincipalTrainer(int team){
        boolean trainer = false;
        switch(team){
            case 1:
                trainer = teamA.teamHasPrincipalTrainer();
            break;
            case 2:
                trainer = teamB.teamHasPrincipalTrainer();
            break;
        }
        return trainer;
    }

    public void addPlayerToTeam(int team, String name, String id, double salary, String number, int goals, double averageMark, String position){
        switch(team){
            case 1:
                employees.add(teamA.addPlayer(name, id, salary, number, goals, averageMark, position));
            break;
            case 2:
                employees.add(teamB.addPlayer(name, id, salary, number, goals, averageMark, position));
            break;
        }
    }

    public void addPrincipalTrainerToTeam(int team, String name, String id, double salary, int experienceYears, int carreerTeams, int carreerChampionships){
        switch(team){
            case 1:
                employees.add(teamA.addPrincipalTrainer(name, id, salary, experienceYears, carreerTeams, carreerChampionships));
            break;
            case 2:
                employees.add(teamB.addPrincipalTrainer(name, id, salary, experienceYears, carreerTeams, carreerChampionships));
            break;
        }
    }

    public void addTrainerAssitantToTeam(int team, String name, String id, double salary, int experienceYears, boolean proPlayer){
        switch(team){
            case 1:
                employees.add(teamA.addTrainerAssistant(name, id, salary, experienceYears, proPlayer));
            break;
            case 2:
                employees.add(teamB.addTrainerAssistant(name, id, salary, experienceYears, proPlayer));
            break;
        }
    }

    public String showIndexPlayers(int team){
        String text = "";
        switch(team){
            case 1:
                text = teamA.showIndexPlayers();
            break;
            case 2:
                text = teamB.showIndexPlayers();
            break;
        }
        return text;
    }

    public String showTeam(int team){
        String text = "";
        switch(team){
            case 1:
                text = teamA.showAllInfo();
            break;
            case 2:
                text = teamB.showAllInfo();
            break;
        }
        return text;
    }
}