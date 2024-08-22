package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.core.entites.User;
import kodlama.io.northwind.core.utilities.DataResult;
import kodlama.io.northwind.core.utilities.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> getByEmail(String email);
}
