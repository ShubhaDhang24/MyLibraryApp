package Dao;

import entity.AppUser;
import entity.Details;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDao {


    AppUser persist(AppUser appUser);

    Collection<AppUser> findAll();
    Optional<AppUser> findById(int id);
    void update(AppUser appUser);
    void delete(AppUser appUser);
}
