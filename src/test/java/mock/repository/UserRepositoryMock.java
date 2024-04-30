package mock.repository;

import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepositoryMock implements UserRepository {
    private final List<User> userList = new ArrayList<>(Arrays.asList(
            new User(1,"Jose","Perez","Garcia","1989-08-18", true, "pass1", "mail1", "jose"),
            new User(2,"Alicia","Fernandez","Lopez","2000-12-04", false, "pass2", "mail2", "alicia"),
            new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true, "pass3", "mail3", "pepe"),
            new User(4,"Mercedes","Gil","Diaz","2000-04-14", false, "pass4", "mail4", "mercedes")
    ));
    private final int sizeList = userList.size();


    @Override
    public User findByIdNutritionist(Integer id) {
        List<User> nutritionistList = findAllNutritionist();
        for (User user:nutritionistList){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    @Override
    public void insert(User user) {
        userList.add(user);
    }
    public boolean verifyInsert(User user){
        insert(user);
        return userList.size() != sizeList;
    }

    @Override
    public List<User> findAllNutritionist() {
        List<User> nutritionistList = new ArrayList<>();
        for (User user:userList){
            if (user.isNutritionist()){
                nutritionistList.add(user);
            }
        }
        return nutritionistList;
    }

    @Override
    public List<User> findAllUser() {
        return userList;
    }
}
