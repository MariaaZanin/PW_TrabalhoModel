package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Classe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistirClasse {
     public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Classe c = new Classe();
        c.setNome("Economica");
        c.setValor(256.90);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
