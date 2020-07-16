import com.fangyou.Dept8001_StartSpringCloudApplication;
import com.fangyou.service.IDeptService;
import com.fangyou.entity.Dept;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = Dept8001_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceImplTest {
    @Resource
    public IDeptService dptService;
    @Test
    public void testFindAll(){
        List<Dept> depts = dptService.findAll();
        Assert.assertNotNull(depts);
        for(Dept dept : depts){
            System.out.println("dName:" + dept.getDname());
            System.out.println("DeptNo:" + dept.getDeptno() );
        }
    }

    @Test
    public void testFindUserById(){
        Dept dept = dptService.findById(1);
        Assert.assertNotNull(dept);
        System.out.println("deptno → " + dept.getDeptno());
        System.out.println("dname → " + dept.getDname());
    }

    @Test
    public void testDoCreate(){
        Dept dept = new Dept();
        dept.setDname("测试部-" + System.currentTimeMillis());
        System.out.println(dptService.addDept(dept));
    }
}
