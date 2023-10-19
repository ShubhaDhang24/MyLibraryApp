package Dao.Impl;

import Dao.AppUserDao;
import entity.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao {
   @PersistenceContext
   private EntityManager entityManager;
    @Override
    @Transactional
    public AppUser persist(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;

    }

    @Override
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("select A from AppUser A", AppUser.class)
                .getResultList();
    }

    @Override
    public Optional<AppUser> findById(int id) {
        AppUser foundUser=entityManager.find(AppUser.class,id);
        return Optional.ofNullable(foundUser);
    }

    @Override
    @Transactional
    public void update(AppUser appUser) {
        entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void delete(AppUser appUser) {
        entityManager.remove(appUser);

    }
}
