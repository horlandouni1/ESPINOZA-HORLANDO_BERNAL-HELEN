package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements iDao<Odontologo>{
    private static final Logger logger= Logger.getLogger(OdontologoDaoH2.class);

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, NUMERO_MATRICULA) VALUES(?,?,?)";
    private static final String SQL_LISTAR = "SELECT * FROM ODONTOLOGOS";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("inicando la operacion de guardado");
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getNombre());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.setString(3, odontologo.getNumeroMatricula());

            psInsert.execute(); //CUANDO SE EJECUTE SE VAN A GENERAR ID
            ResultSet rs= psInsert.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }


        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("inicando la operacion de listar");
        Connection connection=null;
        List<Odontologo> list = new ArrayList<>();
        try{
            connection= BD.getConnection();
            PreparedStatement psListar= connection.prepareStatement(SQL_LISTAR);
            ResultSet rs= psListar.executeQuery();

            while (rs.next()){
                Odontologo odontologo = new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(odontologo);
            }

            logger.info("se obtuvo resultados de busqueda");

        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return list;
    }

}
