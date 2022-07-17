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
        Permissao pusuario = new Permissao();
        pusuario.setNome("USUARIO");
        pusuario.setDescricao("Usuario Simples");
        em.getTransaction().begin();
        em.persist(padmin);
        em.persist(pusuario);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
