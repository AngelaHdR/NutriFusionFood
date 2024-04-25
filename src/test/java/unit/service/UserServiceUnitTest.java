package unit.service;

import com.fpmislata.NutriFusionFood.common.UserIoC;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import mock.repository.UserRepositoryMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class UserServiceUnitTest {
    private static UserService userService;

    @BeforeEach
    public static void setUpAll(){
        userService= UserIoC.getUserService();
        UserIoC.setUserRepository(new UserRepositoryMock());
    }
    @AfterAll
    public static void teardownAll(){
        UserIoC.reset();
    }
}
