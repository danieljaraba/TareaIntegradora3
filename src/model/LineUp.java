package model;

public class LineUp {
    
    //Atributes
    private String date;
    private int[][] positions;

    //Relationships
    private Tactic tactic;

    //Builder
    public LineUp(String date, String tactic){
        this.date = date;
        Tactic aTactic = Tactic.valueOf(tactic);
        this.tactic = aTactic;
    }

    /**
     * @return String return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return int[][] return the positions
     */
    public int[][] getPositions() {
        return positions;
    }

    /**
     * @param positions the positions to set
     */
    public void setPositions(int[][] positions) {
        this.positions = positions;
    }

    /**
     * @return Tactic return the tactic
     */
    public Tactic getTactic() {
        return tactic;
    }

    /**
     * @param tactic the tactic to set
     */
    public void setTactic(Tactic tactic) {
        this.tactic = tactic;
    }

}
