package shubhaDhang.MyLibraryApp.Dao;

import shubhaDhang.MyLibraryApp.entity.Details;

import java.util.Collection;
import java.util.Optional;

public interface DetailsDao {

    Details create(Details details);
    Collection<Details>findAll();
    Optional<Details>findById(int id);
    void update(Details details);
    void delete(Details details);

}
