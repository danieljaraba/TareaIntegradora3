package model;

public class TrainerAssistant extends Trainer {
    
    //Atributes
    private boolean proPlayer;

    //Relationships
    private Expertise expertise;

    //Builder
    public TrainerAssistant(String name, String id, double salary, int experienceYears, boolean proPlayer){
        super(name, id, salary, experienceYears);
        this.proPlayer = proPlayer;
    }

    @Override
    public String showInfo(){
        String text = "\n ----------  Assitant Trainer  ---------- \n" +
                      "Name: " + super.getName() + "\n" +
                      "ID: " + super.getId() + "\n" +
                      "Salary: " + super.getSalary() + "\n";
        if(super.isStatus()){
            text += "Status: ACTIVE \n";
        } else{
            text += "Status: INACTIVE \n";
        }
        text += "Experience Years: " + super.getExperienceYears() + "\n";
        if(proPlayer){
            text += "Was a professional player \n";
        } else{
            text += "Wasn't a professional player \n";
        }
        return text;
    }

    /**
     * @return boolean return the proPlayer
     */
    public boolean isProPlayer() {
        return proPlayer;
    }

    /**
     * @param proPlayer the proPlayer to set
     */
    public void setProPlayer(boolean proPlayer) {
        this.proPlayer = proPlayer;
    }

    /**
     * @return Expertise return the expertise
     */
    public Expertise getExpertise() {
        return expertise;
    }

    /**
     * @param expertise the expertise to set
     */
    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }

}
