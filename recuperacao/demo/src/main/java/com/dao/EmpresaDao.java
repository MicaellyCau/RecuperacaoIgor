package com.dao;

import java.util.List;

import com.basicas.Empresa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmpresaDao {

    private EntityManager em;
    
    public EmpresaDao() {
        this.em = em;
    }

    public void adicionarEmpresa(Empresa ep) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(ep);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public Empresa buscarEmpresa(int id) {
        return em.find(Empresa.class, id);
    }

    public void atualizarEmpresa(Empresa ep) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(ep);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public void removerEmpresa(Empresa ep) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Empresa empresaGerenciada = em.find(Empresa.class, ep.getId());
            if (empresaGerenciada != null) {
                em.remove(empresaGerenciada);
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }

    public List<Empresa> listarEmpesas() {
        return em.createQuery("SELECT f FROM Empresa ep", Empresa.class).getResultList();
    }
    
}
