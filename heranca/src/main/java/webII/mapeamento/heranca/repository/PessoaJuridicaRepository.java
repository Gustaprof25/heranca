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
import webII.mapeamento.heranca.entity.PessoaJuridica;

/**
 *
 * @author Gustavo
 */
@Repository
public class PessoaJuridicaRepository {
  
@PersistenceContext
    private EntityManager em;

    public void save(PessoaJuridica pessoaJuridica){
        em.persist(pessoaJuridica);
    }

    public PessoaJuridica pessoaJuridica(int id){
        return em.find(PessoaJuridica.class, id);
    }

    public List<PessoaJuridica> pessoaJuridica(){
        Query query = em.createQuery("from PessoaJuridica");
        return query.getResultList();
    }

    public void remove(int id){
        PessoaJuridica p = em.find(PessoaJuridica.class, id);
        em.remove(p);
    }

    public void update(PessoaJuridica pessoaJuridica){
        em.merge(pessoaJuridica);
    }
}

