package client;

import java.util.List;

public interface ICliente {
    
    public List lista(Object obj);
    
    public void agregar(Object obj);
    
    public void actualizar(Object obj);
    
    public void borrar(Object obj);
}
