package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoMemory implements iDao<Odontologo>{
    private static final Logger logger= Logger.getLogger(OdontologoDaoMemory.class);

    private List<Odontologo> odontologos;
    public OdontologoDaoMemory() {
        this.odontologos = new ArrayList<>();
    }
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("se guardo odontologo en memoria");
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("se lista todos los odontologos");
        return new ArrayList<>(odontologos);
    }
}
