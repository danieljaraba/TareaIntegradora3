package model;

import model.ProfitableEmployee;

public class PrincipalTrainer extends Trainer implements ProfitableEmployee{
    
    //Atributes
    private int carreerTeams;
    private int carreerChampionships;

    //Builder
    public PrincipalTrainer(String name, String id, double salary, int experienceYears, int carreerTeams, int carreerChampionships){
        super(name, id, salary, experienceYears);
        this.carreerTeams = carreerTeams;
        this.carreerChampionships = carreerChampionships;
    }

    @Override
    public String showInfo(){
        String text = "\n ----------  Principal Trainer  ---------- \n" +
                      "Name: " + super.getName() + "\n" +
                      "ID: " + super.getId() + "\n" +
                      "Salary: " + super.getSalary() + "\n";
        if(super.isStatus()){
            text += "Status: ACTIVE \n";
        } else{
            text += "Status: INACTIVE \n";
        }
        text += "Experience Years: " + super.getExperienceYears() + "\n";
        text += "Carreer Teams: " + carreerTeams + "\n" +
                "Carreer Championships: " + carreerChampionships + "\n" +
                "Market Price: " + calculateMarketPrice() + "\n" +
                "Level: " + calculateLevel() + "\n";
        return text;
    }

    @Override
    public double calculateMarketPrice(){
        double price = (super.getSalary()*10)+(super.getExperienceYears()*100)+(carreerChampionships*50);
        return price;
    }

    @Override
    public double calculateLevel(){
        double level = 5+(carreerChampionships/10);
        return level;
    }

    /**
     * @return int return the carreerTeams
     */
    public int getCarreerTeams() {
        return carreerTeams;
    }

    /**
     * @param carreerTeams the carreerTeams to set
     */
    public void setCarreerTeams(int carreerTeams) {
        this.carreerTeams = carreerTeams;
    }

    /**
     * @return int return the carreerChampionships
     */
    public int getCarreerChampionships() {
        return carreerChampionships;
    }

    /**
     * @param carreerChampionships the carreerChampionships to set
     */
    public void setCarreerChampionships(int carreerChampionships) {
        this.carreerChampionships = carreerChampionships;
    }

}
