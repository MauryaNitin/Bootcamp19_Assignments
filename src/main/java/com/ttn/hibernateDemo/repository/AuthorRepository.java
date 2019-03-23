package com.ttn.hibernateDemo.repository;

import com.ttn.hibernateDemo.BidirectionalOneToManyDemo.AuthorBOTM;
import com.ttn.hibernateDemo.ManyToManyDemo.AuthorMTM;
import com.ttn.hibernateDemo.UnidirectionalOneToManyDemo.entity.AuthorUOTM;
import com.ttn.hibernateDemo.entity.Author;
import com.ttn.hibernateDemo.oneToManyMappingWithoutExtraTableDemo.AuthorOTMWET;
import org.hibernate.Session;

/**
 * Ques 2: Perform CRUD operation for AuthorUOTM class.
 */

public class AuthorRepository {
    public void create(Author author){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }

    public Author get(int id){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Author author = session.get(Author.class, id);
        session.getTransaction().commit();
        return author;
    }

    public void update(Author author){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(author);
        session.getTransaction().commit();
    }

    public void delete(Author author){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(author);
        session.getTransaction().commit();
    }

    public void create(AuthorUOTM author){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }

    public void create(AuthorBOTM author){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }

    public void create(AuthorMTM author){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }

    public void create(AuthorOTMWET author){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }
}
