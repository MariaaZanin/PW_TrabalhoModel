package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoa {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho_PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Maria Eduarda");
        p.setCpf("123.456.789-00");
        p.setEmail("maria@gmail.com");
        p.setTelefone("123456789");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
