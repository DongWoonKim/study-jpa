package com.example.spring.jpastart01.start;

import com.example.spring.jpastart01.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain02 {
    public static void main(String[] args) {
        Member member = Member.builder()
                .id(1L)
                .username("member1")
                .build();


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(member);
        em.detach(member);

        tx.commit();

        em.clear();
        em.close();
        emf.close();
    }
}
