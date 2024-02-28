package org.example.justchecking;

import org.example.model.*;
import org.example.repository.BusinessUnitRepository;
import org.example.service.BusinessUnitService;
import org.testng.annotations.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void toStringTest(){
        List<Role>roleList = new ArrayList<Role>();
        roleList.add(new Role("Admin"));
        User user = new User("name","password",roleList);
        assertEquals("User{id=null, username='name', password='password', roles=[Role{id=null, name='Admin'}]}",user.toString());
    }


}
