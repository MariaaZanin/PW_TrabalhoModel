package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Passagem;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Classe;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistPassagem {
     public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Passagem p = new Passagem();
        p.setBagagem(2);
        p.setDataCompra(Calendar.getInstance());
        p.setPessoa(em.find(Pessoa.class, 3)); 
        p.setClasse(em.find(Classe.class, 7));
        p.setVooAgendado(em.find(VooAgendado.class, 3));
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
