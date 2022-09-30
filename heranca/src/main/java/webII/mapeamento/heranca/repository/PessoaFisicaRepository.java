/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webII.mapeamento.heranca.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import webII.mapeamento.heranca.entity.PessoaFisica;

/**
 *
 * @author Gustavo
 */
@Repository
public class PessoaFisicaRepository {
    
@PersistenceContext
    private EntityManager em;

    public void save(PessoaFisica pessoaFisica){
        em.persist(pessoaFisica);
    }

    public PessoaFisica pessoaFisica(int id){
        return em.find(PessoaFisica.class, id);
    }

    public List<PessoaFisica> pessoaFisica(){
        Query query = em.createQuery("from PessoaFisica");
        return query.getResultList();
    }

    public void remove(int id){
        PessoaFisica p = em.find(PessoaFisica.class, id);
        em.remove(p);
    }

    public void update(PessoaFisica pessoaFisica){
        em.merge(pessoaFisica);
    }
}
