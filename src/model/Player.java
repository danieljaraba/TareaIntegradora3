package model;

public class Player extends Employee implements ProfitableEmployee{
    
    //Atributes
    private String number;
    private int goals;
    private double averageMark;

    //Relationships
    private Role position;

    //Builder
    public Player(String name, String id, double salary, String number, int goals, double averageMark, String position){
        super(name, id, salary);
        this.number = number;
        this.goals = goals;
        this.averageMark = averageMark;
        Role aPosition = Role.valueOf(position);
        this.position = aPosition;
    }

    @Override
    public String showInfo(){
        String text = "\n ----------  Player  ---------- \n" +
                      "Name: " + super.getName() + "\n" +
                      "ID: " + super.getId() + "\n" +
                      "Salary: " + super.getSalary() + "\n";
        if(super.isStatus()){
            text += "Status: ACTIVE \n";
        } else{
            text += "Status: INACTIVE \n";
        }
        text += "Number on T-SHIRT: " + number + "\n" +
                "Goals: " + goals + "\n" +
                "Average Mark: " + averageMark + "\n" +
                "Market price: " + calculateMarketPrice() + "\n" +
                "Level: " + calculateLevel() + "\n";
        return text;
    }

    @Override
    public double calculateMarketPrice(){
        double price = 0;
        switch(position){
            case GOALIE:
                price = (super.getSalary()*12)+(averageMark*150);
            break;
            case DEFENDER:
                price = (super.getSalary()*13)+(averageMark*125)+(goals*100);
            break;
            case FORWARD:
                price = (super.getSalary()*14)+(averageMark*135)+(goals*125);
            break;
            case MIDFIELD:
                price = (super.getSalary()*15)+(averageMark*145)+(goals*150);
            break;
        }
        return price;
    }

    @Override
    public double calculateLevel(){
        double level = 0;
        switch(position){
            case GOALIE:
                level = (averageMark*0.9);
            break;
            case DEFENDER:
                level = (averageMark*0.9)+(goals/100);
            break;
            case FORWARD:
                level = (averageMark*0.9)+(goals/90);
            break;
            case MIDFIELD:
                level = (averageMark*0.9)+(goals/80);
            break;
        }
        return level;
    }

    /**
     * @return String return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return int return the goals
     */
    public int getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }

    /**
     * @return double return the averageMark
     */
    public double getAverageMark() {
        return averageMark;
    }

    /**
     * @param averageMark the averageMark to set
     */
    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    /**
     * @return Role return the position
     */
    public Role getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Role position) {
        this.position = position;
    }

}
