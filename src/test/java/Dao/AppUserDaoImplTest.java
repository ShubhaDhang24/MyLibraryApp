package Dao;

import Dao.Impl.AppUserDaoImpl;
import entity.AppUser;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback
class AppUserDaoImplTest {
    @Autowired
    AppUserDaoImpl userDao;
    @Test
    public void testPersistAppUser()
{
    //Action
    AppUser appUser=new AppUser("Test","12345");
    AppUser createdAppUser=userDao.persist(appUser);
    //Assert
    Assertions.assertNotNull(createdAppUser);

}




}
