import com.fangyou.Dept8001_StartSpringCloudApplication;
import com.fangyou.dept.controller.DeptRestController;
import com.fangyou.dept.entity.DeptEntity;
import com.fangyou.dept.service.IDeptService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = Dept8001_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceImplTest {
    @Resource
    public IDeptService dptService;

    private MockMvc mockMvc;

    @Test
    public void testFindAll(){
        List<DeptEntity> depts = dptService.findAll();
        Assert.assertNotNull(depts);
        for(DeptEntity dept : depts){
            System.out.println("dName:" + dept.getDname());
            System.out.println("DeptNo:" + dept.getDeptno() );
        }
    }

    @Test
    public void testFindUserById(){
        DeptEntity dept = dptService.findById(1);
        Assert.assertNotNull(dept);
        System.out.println("deptno → " + dept.getDeptno());
        System.out.println("dname → " + dept.getDname());
    }

    @Test
    public void testDoCreate(){
        DeptEntity dept = new DeptEntity();
        dept.setDname("测试部-" + System.currentTimeMillis());
        System.out.println(dptService.addDept(dept));
    }

    @Test
    public void hello(){
        System.out.println("hello World");
    }

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new DeptRestController()).build();
    }

    @Test
    public void getHello() throws Exception {
       /* mockMvc.perform(MockMvcRequestBuilders.post("/helloWord?name=小花")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print());*/

       /* mockMvc.perform(MockMvcRequestBuilders.post("/helloWord?name=小花")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小明")));*/
        mockMvc.perform(MockMvcRequestBuilders.post("/helloWord?name=小花")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小花")));
    }
}
