package dao;

public class PerroDAO {
    
    private int id;
    private String raza;
    private String comportamiento;
    private int edad;
    
    public PerroDAO(){
    }
    
    public PerroDAO(int id){
        this.id = id;
    }

    public PerroDAO(String raza, String comportamiento, int edad){
        this.raza = raza;
        this.comportamiento = comportamiento;
        this.edad = edad;
    }
    
    public PerroDAO(int id, String raza, String comportamiento, int edad){
        this.id = id;
        this.raza = raza;
        this.comportamiento = comportamiento;
        this.edad = edad;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setRaza(String raza){
        this.raza = raza;
    }
    
    public String getRaza(){
        return this.raza;
    }
    
    public void setComportamiento(String comportamiento){
        this.comportamiento = comportamiento;
    }
    
    public String getComportamiento(){
        return this.comportamiento;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    @Override
    public String toString(){
        return "ID: [" + this.id + "] \n" +
                "Raza: [" + this.raza + "] \n" +
                "Comportamiento [" + this.comportamiento + "] \n" +
                "Edad: [" + this.edad + "] \n" +
                "\n";
    }
}
