package ch.zhaw.sml.iwi.pmis.meng.simplebackend.boundary;

import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Consultation;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.ConsultationRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
@Path("/consultations")
public class ConsultationsService {



    @Autowired
    private ConsultationRepository consultationRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consultation> getAllConsultaions() {
        List<Consultation> resList = new ArrayList<>();
        for(Consultation c : consultationRepository.findAll()) {
            //Hibernate.initialize(c.getAttributes());
            resList.add(c);
        }
        return resList;
    }

    /*
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Part getEntry(@PathParam("id") String identString) {        
        return InventoryRepository.getInstance().getParts().get(identString);
    }
   
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEntry(Part part, @PathParam("id") String identString) {  
        part.setName(identString);
        InventoryRepository.getInstance().getParts().put(identString, part);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEntry(Part part) {        
        InventoryRepository.getInstance().getParts().put(part.getName(), part);
    }
    
    @DELETE
    @Path("/{id}")
    public void updateEntry(@PathParam("id") String identString) {        
        InventoryRepository.getInstance().getParts().remove(identString);
    }
*/
}
