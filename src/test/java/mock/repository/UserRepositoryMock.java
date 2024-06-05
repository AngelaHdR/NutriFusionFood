package mock.repository;

import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;
import data.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryMock implements UserRepository {
    private final List<User> userList = new ArrayList<>(UserData.userList);
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
            if (user.getNutritionist()){
                nutritionistList.add(user);
            }
        }
        return nutritionistList;
    }

    @Override
    public List<User> findAllUser() {
        return userList;
    }

    @Override
    public User findByEmailOrUsername(String email, String username) {
        for (User user:userList){
            if (user.getUsername().equals(username) || user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
