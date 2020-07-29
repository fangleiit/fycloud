import com.fangyou.User8002_StartSpringCloudApplication;
import com.fangyou.controller.SysUserController;
import com.fangyou.entity.Dept;
import com.fangyou.entity.SysUser;
import com.fangyou.service.ISysUserService;
import com.fangyou.service.impl.SysUserServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = User8002_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ISysUserServiceImplTest {
    @Resource
    public ISysUserService sysUserService;

    private MockMvc mockMvc;

    @Test
    public void testFindAll(){
        List<SysUser> susUsers = sysUserService.findUsers();
        Assert.assertNotNull(susUsers);
        for(SysUser sysUser : susUsers){
            System.out.println("realname:" + sysUser.getRealname());
            System.out.println("address:" + sysUser.getCurrentAddress() );
        }
    }

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new SysUserController()).build();
    }

    @Test
    public void getFindUsersByNameAndPass() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/sysuser/findloginuser?username=admin&password=123456")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print());

       /* mockMvc.perform(MockMvcRequestBuilders.post("/helloWord?name=小花")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小明")));*/
       /* mockMvc.perform(MockMvcRequestBuilders.post("/sysuser/findloginuser?username=admin&password=123456")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小花")));*/
    }

}
