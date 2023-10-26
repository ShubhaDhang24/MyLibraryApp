package shubhaDhang.MyLibraryApp.Dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import shubhaDhang.MyLibraryApp.Dao.AuthorDao;
import shubhaDhang.MyLibraryApp.entity.Author;

import java.util.Collection;
import java.util.Optional;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Author persist(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        entityManager.merge(author);
        return author;
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author);

    }

    @Override
    public Optional<Author> findById(int id) {
        Author author=entityManager.find(Author.class,id);
        return Optional.ofNullable(author);
    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("select A from Author A", Author.class).getResultList();
    }
}
