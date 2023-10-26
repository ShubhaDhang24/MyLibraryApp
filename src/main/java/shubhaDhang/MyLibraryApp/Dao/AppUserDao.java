package shubhaDhang.MyLibraryApp.Dao;

import shubhaDhang.MyLibraryApp.entity.AppUser;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDao {


    AppUser persist(AppUser appUser);

    Collection<AppUser> findAll();
    Optional<AppUser> findById(int id);
    void update(AppUser appUser);
    void delete(AppUser appUser);
}
