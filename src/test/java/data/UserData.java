package data;

import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserData {
    public static final List<UserEntity> userEntityList = new ArrayList<>(Arrays.asList(
            new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true,"password1","mail1","jose"),
            new UserEntity(2,"Alicia","Fernandez","Lopez","2000-12-04", false,"password2","mail2","alicia"),
            new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"password3","mail3","pepe"),
            new UserEntity(4,"Mercedes","Gil","Diaz","2000-04-14", false,"password4","mail4","mercedes")
    ));
    public static final List<User> userList = new ArrayList<>(Arrays.asList(
            new User(1,"Jose","Perez","Garcia","1989-08-18", true,"password1","mail1","jose"),
            new User(2,"Alicia","Fernandez","Lopez","2000-12-04", false,"password2","mail2","alicia"),
            new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"password3","mail3","pepe"),
            new User(4,"Mercedes","Gil","Diaz","2000-04-14", false,"password4","mail4","mercedes")
    ));
}
