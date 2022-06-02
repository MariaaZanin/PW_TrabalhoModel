package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirVooAgendado {
     public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        VooAgendado va = new VooAgendado();
        va.setAeronave("Nave1");
        va.setTotalPassageiros(60);
        va.setData(Calendar.getInstance());
        Voo v = em.find(Voo.class, 24);
        va.setVoo(v);
        em.getTransaction().begin();
        em.persist(va);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
