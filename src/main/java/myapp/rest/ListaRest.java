/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import myapp.entity.Lista;
import myapp.service.ListaDBService;

/**
 *
 * @author aloukopoulos
 */

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ListaRest {
    
    @Inject
    ListaDBService lserv;
    
    
    @Path("new")
    @POST
    public Response createLista(Lista l){
        // m1/new
        lserv.createLista(l);
        
        return Response.ok(l).build();
    }
    
    @Path("upd")
    @PUT
    public Response updateLista(Lista l){
        // m1/upd
        lserv.updateLista(l);
        
        return Response.ok(l).build();
    }
    
    @Path("{id}")
    @GET
    public Lista getLista(@PathParam("id")Long id){
        // m1/id
        return lserv.findLista(id);
    }
    
    @Path("all")
    @GET
    public List <Lista> getListas(){
        // m1/all
        return lserv.getListas();
    }
    
    @Path("status")
    @POST
    public Response statusLista(@QueryParam("id") Long id){
        // m1/status?id=1
        Lista l = lserv.findLista(id);
        
        return Response.ok(l.getIsCompleted()).build();
    }
    
}
