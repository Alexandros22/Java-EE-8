/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import myapp.entity.Lista;

/**
 *
 * @author aloukopoulos
 */

@Transactional
public class ListaDBService {
    
    @PersistenceContext
    EntityManager en;
    
    
    
    
    public Lista createLista(Lista l){
        
        //persist into db
        en.persist(l);
        
        return l;
    }
    
    public Lista updateLista(Lista l){
        
        en.merge(l);
        
        return l;
    }
   
    public Lista findLista(Long id){
        
        return en.find(Lista.class, id);
    }
    
    public List<Lista> getListas(){
        return en.createQuery("SELECT l from Lista l", Lista.class).getResultList();
    }
    
}
