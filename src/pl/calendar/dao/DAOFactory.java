package pl.calendar.dao;
 
import pl.calendar.exception.NoSuchDbTypeException;
 
public abstract class DAOFactory {
     
    public static final int MYSQL_DAO_FACTORY = 1;
 
    public abstract EventDAO getEventDAO();
 
    public abstract UserDAO getUserDAO();
    
    public abstract PlantDAO getPlantDAO();
 
 
    public static DAOFactory getDAOFactory() {
        DAOFactory factory = null;
        try {
            factory = getDAOFactory(MYSQL_DAO_FACTORY);
        } catch (NoSuchDbTypeException e) {
            e.printStackTrace();
        }
        return factory;
    }
     
    private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
        switch (type) {
        case MYSQL_DAO_FACTORY:
            return new MysqlDAOFactory();
        default:
            throw new NoSuchDbTypeException();
        }
    }
}