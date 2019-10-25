/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import modelos.GameCommands;

/**
 * REST Web Service
 *
 * @author mblabs
 */
@Path("Jogo2048")
public class JogoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JogoWS
     */
    public JogoWS() {
    }

    /**
     * Retrieves representation of an instance of WS.JogoWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("comando/{option}")
    public String getJson(@PathParam("option") String option) {
        if(option.equals("Up") || option.equals("Right") || option.equals("Left")  || option.equals("Down") ){
            GameCommands gc = new GameCommands();
            gc.setCommand(option);
            Gson g = new Gson();
            return g.toJson(gc);
        }
        else {
            String response = "Option command not available";
            Gson g = new Gson();
            return g.toJson(response);
        }

    }

    /**
     * PUT method for updating or creating an instance of JogoWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}