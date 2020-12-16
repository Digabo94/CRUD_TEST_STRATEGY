package dto_strategy;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public interface IObjectDTO {
    
    public List select();
    
    public void insert(Object obj);
    
    public void update(Object obj);
    
    public void delete(Object obj);
}
