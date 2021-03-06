package model;

import java.util.ArrayList;

public class Club {

    //Atributes
    private String name;
    private String nit;
    private String foundationDate;
    private String[][] dressingRoomA;
    private String[][] dressingRoomB;
    private String[][] officeSector;

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
        this.officeSector = new String[6][6];
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

    public String showEmployees(){
        String text = "\n**********  Employees  ***********\n";
        for(int i = 0; i<employees.size(); i++){
            text += employees.get(i).showInfo() + "\n";
        }
        return text;
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

    public String showIndexAssistant(int team){
        String text = "";
        switch(team){
            case 1:
                text = teamA.showIndexAssistants();
            break;
            case 2:
                text = teamB.showIndexAssistants();
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

    public void firePlayer(int team, int index){
        Player firedPlayer = null;
        int size = employees.size();
        switch(team){
            case 1:
                firedPlayer = teamA.firePlayer(index);
                for(int i = 0; i<size; i++){
                    if(firedPlayer.getName() == employees.get(i).getName()){
                        employees.set(i, firedPlayer);
                    }
                }
            break;
            case 2:
                firedPlayer = teamB.firePlayer(index);
                    for(int i = 0; i<size; i++){
                        if(firedPlayer.getName() == employees.get(i).getName()){
                            employees.set(i, firedPlayer);
                        }
                    }
            break;
        }
    }

    public void firePrincipal(int team){
        PrincipalTrainer firedPrincipal = null;
        int size = employees.size();
        switch(team){
            case 1:
                firedPrincipal = teamA.firePrincipal();
                for(int i = 0; i<size; i++){
                    if(firedPrincipal.getName() == employees.get(i).getName()){
                        employees.set(i, firedPrincipal);
                    }
                }
            break;
            case 2:
                firedPrincipal = teamB.firePrincipal();
                    for(int i = 0; i<size; i++){
                        if(firedPrincipal.getName() == employees.get(i).getName()){
                            employees.set(i, firedPrincipal);
                        }
                    }
            break;
        }
    }

    public void fireAssitant(int team, int index){
        TrainerAssistant firedAssistant = null;
        int size = employees.size();
        switch(team){
            case 1:
                firedAssistant = teamA.fireAssistant(index);
                for(int i = 0; i<size; i++){
                    if(firedAssistant.getName() == employees.get(i).getName()){
                        employees.set(i, firedAssistant);
                    }
                }
            break;
            case 2:
                firedAssistant = teamB.fireAssistant(index);
                    for(int i = 0; i<size; i++){
                        if(firedAssistant.getName() == employees.get(i).getName()){
                            employees.set(i, firedAssistant);
                        }
                    }
            break;
        }
    }

    public String showDressingRoomA(){
        String text = "\n-----------  Dressing Room A  ----------\n";
        boolean set = false;
        Player[] cPlayers = teamA.getPlayers().clone();
        for(int i = 0; i<dressingRoomA.length; i= i+2){
            for(int j = 0; j<dressingRoomA[0].length; j = j+2){
                set = false;
                for(int k = 0; k<cPlayers.length && !set; k++){
                    if(cPlayers[k] != null){
                        dressingRoomA[i][j] = cPlayers[k].getName();
                        cPlayers[k] = null;
                        set = true;
                    }
                }
            }
        }
        for(int i = 0; i<dressingRoomA.length; i++){
            for(int j = 0; j<dressingRoomA[0].length; j++){
                if(dressingRoomA[i][j] != null){
                    text += dressingRoomA[i][j] + "\t";
                } else{
                    text += "Empty \t";
                }
            }
            text += "\n";
        }
        return text;
    }

    public String showDressingRoomB(){
        String text = "\n-----------  Dressing Room B  ----------\n";
        boolean set = false;
        Player[] cPlayers = teamB.getPlayers().clone();
        for(int i = 0; i<dressingRoomB.length; i= i+2){
            for(int j = 0; j<dressingRoomB[0].length; j = j+2){
                set = false;
                for(int k = 0; k<cPlayers.length && !set; k++){
                    if(cPlayers[k] != null){
                        dressingRoomB[i][j] = cPlayers[k].getName();
                        cPlayers[k] = null;
                        set = true;
                    }
                }
            }
        }
        for(int i = 0; i<dressingRoomB.length; i++){
            for(int j = 0; j<dressingRoomB[0].length; j++){
                if(dressingRoomB[i][j] != null){
                    text += dressingRoomB[i][j] + "\t";
                } else{
                    text += "Empty \t";
                }
            }
            text += "\n";
        }
        return text;
    }

    public String showOfficeSector(){
        String text = "\n-----------  Office Sector  ----------\n";
        boolean set = false;
        ArrayList<Employee> cEmployees = employees;
        for(int i = 0; i<officeSector.length; i= i+2){
            for(int j = 0; j<officeSector[0].length; j = j+2){
                set = false;
                for(int k = 0; k<cEmployees.size() && !set; k++){
                    if((cEmployees.get(k) instanceof PrincipalTrainer || cEmployees.get(k) instanceof TrainerAssistant) && cEmployees.get(k).isStatus()){
                        if(officeSector[i][j] == null){
                            officeSector[i][j] = cEmployees.get(k).getName();
                            cEmployees.remove(k);
                            set = true;
                        }
                    }
                }
            }
        }
        for(int i = 0; i<officeSector.length; i++){
            for(int j = 0; j<officeSector[0].length; j++){
                if(officeSector[i][j] != null){
                    text += officeSector[i][j] + "\t";
                } else{
                    text += "Empty \t";
                }
            }
            text += "\n";
        }
        return text;
    }

    public void addLineUp(int team, String date, String tactic, String formation){
        switch(team){
            case 1:
                teamA.addLineUp(date, tactic, formation);
            break;
            case 2:
                teamB.addLineUp(date, tactic, formation);
            break;
        }
    }

    public String showLineUps(){
        String text = "\n----------  Team A  ---------\n";
        text += teamA.showLineUps();
        text += "\n--------  Team B  ---------\n";
        text += teamB.showLineUps();
        return text;
    }
}