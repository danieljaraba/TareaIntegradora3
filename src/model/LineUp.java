package model;

public class LineUp {
    
    //Atributes
    private String date;
    private String formation;
    private int[][] positions;

    //Relationships
    private Tactic tactic;

    //Builder
    public LineUp(String date, String tactic, String formation){
        this.date = date;
        Tactic aTactic = Tactic.valueOf(tactic);
        this.tactic = aTactic;
        this.formation = formation;
        this.positions = new int[10][7];
    }

    public void actualizeLineUp(){
        String[] numbers = formation.split("-");
        int advance = (int)10/numbers.length;
        int index = 0;
        String number = "";
        for(int i = positions.length-1; i>=0 && index<numbers.length; i = i-advance){
            number = numbers[index];
            switch(number){
                case "1":
                    positions[i][3] = 1;
                break;
                case "2":
                    positions[i][2] = 1;
                    positions[i][4] = 1;
                break;
                case "3":
                    positions[i][1] = 1;
                    positions[i][3] = 1;
                    positions[i][5] = 1;
                break;
                case "4":
                    positions[i][1] = 1;
                    positions[i][2] = 1;
                    positions[i][4] = 1;
                    positions[i][5] = 1;
                break;
                case "5":
                    positions[i][1] = 1;
                    positions[i][2] = 1;
                    positions[i][3] = 1;
                    positions[i][4] = 1;
                    positions[i][5] = 1;
                break;
                case "6":
                    positions[i][1] = 1;
                    positions[i][2] = 1;
                    positions[i][3] = 1;
                    positions[i][4] = 1;
                    positions[i][5] = 1;
                    positions[i][6] = 1;
                break;
                case "7":
                    positions[i][1] = 1;
                    positions[i][2] = 1;
                    positions[i][3] = 1;
                    positions[i][4] = 1;
                    positions[i][5] = 1;
                    positions[i][6] = 1;
                    positions[i][0] = 1;
                break;
            }
            index++;
        }
    }

    public String showLineUp(){
        actualizeLineUp();
        String text = "\n**********  LineUp  *********\n" +
                      "Date: " + date + "\n" +
                      "Tactic: " + tactic + "\n" +
                      "Formation: " + formation + "\n";
        for(int i = 0; i<positions.length; i++){
            for(int j = 0; j<positions[0].length; j++){
                text += positions[i][j] + "\t";
            }
            text += "\n";
        }
        text += "\n";
        return text;
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
