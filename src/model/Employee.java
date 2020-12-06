package model;

public abstract class Employee {
    
    //Atributes
    private String name;
    private String id;
    private double salary;
    private boolean status;

    //Builder
    public Employee(String name, String id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.status = true;
    }

    public String showInfo(){
        String text = "\n ----------  Employee  ---------- \n" +
                      "Name: " + name + "\n" +
                      "ID: " + id + "\n" +
                      "Salary: " + salary + "\n";
        if(status){
            text += "Status: ACTIVE \n";
        } else{
            text += "Status: INACTIVE \n";
        }
        return text;
    }

    public void fireEmployee(){
        status = false;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return double return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return boolean return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
