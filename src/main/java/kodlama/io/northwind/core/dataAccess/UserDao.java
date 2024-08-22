package kodlama.io.northwind.core.dataAccess;

import kodlama.io.northwind.core.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User getByEmail(String email);
}
