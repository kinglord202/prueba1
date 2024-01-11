package Service;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Servicio")
public class Servicio {

    private final PersonaDAO personaDAO = new PersonaDAO();

    @WebMethod(operationName = "listarPersonas")
    public List<Persona> listarPersonas() {
        return personaDAO.listar();
    }

    @WebMethod(operationName = "obtenerPersona")
    public Persona obtenerPersona(@WebParam(name = "id") int id) {
        return personaDAO.list(id);
    }

    @WebMethod(operationName = "agregarPersona")
    public boolean agregarPersona(@WebParam(name = "persona") Persona persona) {
        return personaDAO.add(persona);
    }

    @WebMethod(operationName = "actualizarPersona")
    public boolean actualizarPersona(@WebParam(name = "persona") Persona persona) {
        // Puedes validar si la persona con el ID existe antes de intentar actualizar
        return personaDAO.edit(persona);
    }

    @WebMethod(operationName = "eliminarPersona")
    public boolean eliminarPersona(@WebParam(name = "id") int id) {
        return personaDAO.eliminar(id);
    }
}
