package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.dataAccess.UserDao;
import kodlama.io.northwind.core.entites.User;
import kodlama.io.northwind.core.utilities.DataResult;
import kodlama.io.northwind.core.utilities.Result;
import kodlama.io.northwind.core.utilities.SuccessDataResult;
import kodlama.io.northwind.core.utilities.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email),"Kullanıcı bulundu");
    }
}
