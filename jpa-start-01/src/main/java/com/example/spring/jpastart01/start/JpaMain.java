package com.example.spring.jpastart01.start;

import com.example.spring.jpastart01.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        System.out.println("JpaMain start");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaBook");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            emf.close();
        }

    }

    private static void logic(EntityManager em) {

        Member user1 = Member.builder()
                .username("user1")
                .age(11)
                .build();

        em.persist(user1);

        user1.setAge(22);

        Member getUser1 = em.find(Member.class, user1.getId());
        System.out.println("get user1 : " + getUser1);

        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
        System.out.println("members size : " + members.size());

//        em.remove(getUser1);
    }
}
