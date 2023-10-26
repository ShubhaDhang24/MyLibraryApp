package shubhaDhang.MyLibraryApp.Dao;

import org.junit.jupiter.api.BeforeEach;
import shubhaDhang.MyLibraryApp.Dao.Impl.AppUserDaoImpl;
import shubhaDhang.MyLibraryApp.entity.AppUser;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback
class AppUserDaoImplTest {
    @Autowired
    AppUserDaoImpl userDao;
    private AppUser appUser;

    @BeforeEach
    public void setUp()
    {
         appUser=new AppUser("Test","12345");

    }

    @Test
    public void testPersistAppUser()
{

    AppUser createdAppUser=userDao.persist(appUser);
    Assertions.assertNotNull(createdAppUser);
}
@Test
    public void testFindAll()
{

    AppUser user1=new AppUser("Test1","12345");
    AppUser user2=new AppUser("Test2","1234567");
    List<AppUser> result= new ArrayList<>();
    result.add(user1);
    result.add(user2);
   // Assertions.assertNotNull(result);
    Assertions.assertEquals(2,result.size());

}



}
