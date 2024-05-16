package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger logger= Logger.getLogger(BD.class);
    private static final String SQL_DROP_CREATE_ODONTOLOGOS="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, " +
            "NUMERO_MATRICULA VARCHAR(50) NOT NULL) ";
    private static final String SQL_PRUEBA="INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, NUMERO_MATRICULA) VALUES('Paco','Pereyra','123456'),('Maria','Heredia','11111111'); ";


    public static void crearTablas(){
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE_ODONTOLOGOS);
            statement.execute(SQL_PRUEBA);
            logger.info("tabla creada con exito");

        }catch (Exception e){
            logger.warn(e.getMessage());
        }

    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/C2ClinicaOdontologica","sa","sa");
    }
}
