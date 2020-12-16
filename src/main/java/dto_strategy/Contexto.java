package dto_strategy;

import java.util.List;

public class Contexto {
    
    //Implementacion del patron de disenio strategy
    
    private IObjectDTO iObjectDto;
    
    public Contexto(IObjectDTO iObjectDto){
        this.iObjectDto = iObjectDto;
    }
    
    public List executeSelect(){
        return this.iObjectDto.select();
    }
    
    public void executeInsert(Object obj){
        this.iObjectDto.insert(obj);
    }
    
    public void executeUpdate(Object obj){
        this.iObjectDto.update(obj);
    }
    
    public void executeDelete(Object obj){
        this.iObjectDto.delete(obj);
    }
}
