package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirAeroporto {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Aeroporto a = new Aeroporto();
        a.setNome("Aeroporto PF");
        a.setOperacaoNoturna(true);
        a.setCidade(em.find(Cidade.class, 2)); 
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
