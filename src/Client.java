import dao.BD;
import model.Odontologo;
import service.OdontologoMemoryService;
import service.OdontologoService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        BD.crearTablas();
        Odontologo odontologo = new Odontologo("Horlando","Espinoza","12313");
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologo(odontologo);
        List<Odontologo> lista = odontologoService.buscarTodos();

        lista.forEach(Odontologo::toString);
        System.out.println(lista);
        // guardado en memoria
        Odontologo odontologo2 = new Odontologo(1,"Mario","Rios","12313");
        Odontologo odontologo3 = new Odontologo(2,"Pepe","Meza","12313");

        OdontologoMemoryService odontologoMemoryService = new OdontologoMemoryService();
        odontologoMemoryService.guardarOdontologoMemory(odontologo2);
        odontologoMemoryService.guardarOdontologoMemory(odontologo3);

        List<Odontologo> lista2 = odontologoMemoryService.buscarTodosMemory();
        lista2.forEach(Odontologo::toString);
        System.out.println(lista2);
    }
}
