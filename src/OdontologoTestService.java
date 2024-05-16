import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoMemoryService;
import service.OdontologoService;

import java.util.List;

public class OdontologoTestService {
    @Test
    public void guardarOdontologo(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        Odontologo odontologo = new Odontologo("Carlos","Espinoza","12343");
        Odontologo odontologoGuardado= odontologoService.guardarOdontologo(odontologo);
        Assertions.assertTrue(odontologoGuardado!=null);
    }
    @Test
    public void listarOdontologos(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        Odontologo odontologo = new Odontologo("Carlos","Espinoza","12343");
        Odontologo odontologoGuardado= odontologoService.guardarOdontologo(odontologo);
        List<Odontologo> lista = odontologoService.buscarTodos();
        Assertions.assertTrue(lista.size() == 3);
    }
    @Test
    public void guardarOdontologoMemory(){
        OdontologoMemoryService odontologoMemoryService = new OdontologoMemoryService();
        Odontologo odontologo2 = new Odontologo(1,"Mario","Rios","12313");
        Odontologo odontologoGuardado= odontologoMemoryService.guardarOdontologoMemory(odontologo2);

        Assertions.assertTrue(odontologoGuardado!=null);
    }
    @Test
    public void listarOdontologosMemory(){
        OdontologoMemoryService odontologoMemoryService = new OdontologoMemoryService();
        Odontologo odontologo2 = new Odontologo(1,"Mario","Rios","12313");
        Odontologo odontologo3 = new Odontologo(2,"Pepe","Meza","12313");
        Odontologo odontologoGuardado= odontologoMemoryService.guardarOdontologoMemory(odontologo2);
        Odontologo odontologoGuardado2= odontologoMemoryService.guardarOdontologoMemory(odontologo3);

        List<Odontologo> lista2 = odontologoMemoryService.buscarTodosMemory();
        Assertions.assertTrue(lista2.size() == 2);
    }
}
