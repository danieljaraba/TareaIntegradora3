package model;

public abstract class Trainer extends Employee {
    
    //Relationships
    private int experienceYears;

    //Builder
    public Trainer(String name, String id, double salary, int experienceYears){
        super(name, id, salary);
        this.experienceYears = experienceYears;
    }

    @Override
    public String showInfo(){
        String text = "\n ----------  Trainer  ---------- \n" +
                      "Name: " + super.getName() + "\n" +
                      "ID: " + super.getId() + "\n" +
                      "Salary: " + super.getSalary() + "\n";
        if(super.isStatus()){
            text += "Status: ACTIVE \n";
        } else{
            text += "Status: INACTIVE \n";
        }
        text += "Experience Years: " + experienceYears + "\n";
        return text;
    }

    /**
     * @return int return the experienceYears
     */
    public int getExperienceYears() {
        return experienceYears;
    }

    /**
     * @param experienceYears the experienceYears to set
     */
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

}
