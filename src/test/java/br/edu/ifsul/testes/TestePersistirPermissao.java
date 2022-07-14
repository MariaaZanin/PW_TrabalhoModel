package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPermissao {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Permissao padmin = new Permissao();
        padmin.setNome("ADMINISTRADOR");
        padmin.setDescricao("Usuario admin");
        em.getTransaction().begin();
        em.persist(padmin);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
