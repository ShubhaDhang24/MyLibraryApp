package Dao.Impl;

import Dao.DetailsDao;
import entity.Details;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class DetailsDaoImpl implements DetailsDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("select D from Details D", Details.class)
                .getResultList();
    }

    @Override
    public Optional<Details> findById(int id) {
       Details foundDetails =entityManager.find(Details.class,id);

        return Optional.ofNullable(foundDetails);
    }

    @Override
    public void update(Details details)
    {
        entityManager.merge(details);
    }


    @Override
    public void delete(Details details) {
        entityManager.remove(details);

    }
}
