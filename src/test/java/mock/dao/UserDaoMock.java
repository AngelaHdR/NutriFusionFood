package mock.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;
import data.UserData;

public class UserDaoMock implements UserDao {
    private final List<UserEntity> userEntityList = new ArrayList<>(UserData.userEntityList);

    @Override
    public List<UserEntity> findAllUser() {
        return userEntityList;
    }

    @Override
    public UserEntity findByIdUser(Integer id) {
        List<UserEntity> nutritionistList = findAllNutritionist();
        for (UserEntity userEntity:nutritionistList){
            if (userEntity.getId().equals(id)){
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public void insert(UserEntity userEntity) {
        userEntityList.add(userEntity);
    }

    @Override
    public List<UserEntity> findAllNutritionist() {
        List<UserEntity> nutritionistList = new ArrayList<>();
        for (UserEntity userEntity:userEntityList){
            if (userEntity.isNutritionist()){
                nutritionistList.add(userEntity);
            }
        }
        return nutritionistList;
    }

    @Override
    public UserEntity findByEmail(String email, String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmailOrUsername'");
    }

    @Override
    public UserEntity findByUsername(String username, String password) {
        throw new UnsupportedOperationException("Unimplemented method 'findByEmailOrUsername'");
    }
}
