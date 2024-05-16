package service;

import dao.OdontologoDaoH2;
import dao.OdontologoDaoMemory;
import dao.iDao;
import model.Odontologo;

import java.util.List;

public class OdontologoMemoryService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoMemoryService() {
        odontologoiDao= new OdontologoDaoMemory();
    }
    public Odontologo guardarOdontologoMemory(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }
    public List<Odontologo> buscarTodosMemory(){
        return odontologoiDao.buscarTodos();
    }
}
