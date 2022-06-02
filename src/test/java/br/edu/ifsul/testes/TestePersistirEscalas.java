package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.Aeroporto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirEscalas {
     public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Voo v = em.find(Voo.class, 24);
        Aeroporto a = em.find(Aeroporto.class, 23);
        v.getAeroporto().add(a);
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
