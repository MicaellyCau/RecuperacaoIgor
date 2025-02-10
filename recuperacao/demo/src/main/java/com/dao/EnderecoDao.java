package com.dao;


import java.util.List;

import com.basicas.Endereco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EnderecoDao {

        
        private EntityManager em;
    
        public EnderecoDao() {
            this.em = em;
        }
    
        public void adicionarEndereco(Endereco e) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(e);
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
        public Endereco buscarEndereco(int id) {
            return em.find(Endereco.class, id);
        }
    
        public void atualizarEndereco(Endereco e) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.merge(e);
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
            }
        }
    
    
        public List<Endereco> listarEnderecos() {
            return em.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
        }
    }
    

