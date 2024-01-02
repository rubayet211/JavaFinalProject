package dev.repository;

import dev.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final SessionFactory sessionFactory;
    @Autowired
    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    public List<Book> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> userQuery = session.createQuery("from Book", Book.class);
        return userQuery.getResultList();
    }
    public void edit(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = get(id);
        session.delete(book);
    }

    public Book get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }
}
