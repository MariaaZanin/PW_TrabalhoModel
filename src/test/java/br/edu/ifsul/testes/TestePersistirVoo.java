package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Voo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirVoo {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Voo v = new Voo();
        v.setDescricao("Voo1");
        v.setTempoEstimado(30.5);
        v.setAtivo(true);
        v.setPeriodicidade("nao sei");
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
