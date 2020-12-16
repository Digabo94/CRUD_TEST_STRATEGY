package client;

import java.util.List;
import dto_strategy.*;
import dao.*;

public class Cliente implements ICliente {

    Contexto context;

    @Override
    public List lista(Object obj) {
        IObjectDTO objectDto = null;
        List lista = null;
        if (obj instanceof PerroDAO) {
            objectDto = new PerroDTO();
        } else if (obj instanceof PersonaDAO) {
            objectDto = new PerroDTO();
        }
        return lista;
    }

    @Override
    public void agregar(Object obj) {
        context.executeInsert(obj);
    }

    @Override
    public void actualizar(Object obj) {
        context.executeUpdate(obj);
    }

    @Override
    public void borrar(Object obj) {
        context.executeDelete(obj);
    }

}
