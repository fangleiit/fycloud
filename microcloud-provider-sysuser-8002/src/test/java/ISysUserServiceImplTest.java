import com.fangyou.User8002_StartSpringCloudApplication;
import com.fangyou.entity.Dept;
import com.fangyou.entity.SysUser;
import com.fangyou.service.ISysUserService;
import com.fangyou.service.impl.SysUserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = User8002_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ISysUserServiceImplTest {
    @Resource
    public ISysUserService sysUserService;
    @Test
    public void testFindAll(){
        List<SysUser> susUsers = sysUserService.findUsers();
        Assert.assertNotNull(susUsers);
        for(SysUser sysUser : susUsers){
            System.out.println("realname:" + sysUser.getRealname());
            System.out.println("address:" + sysUser.getCurrentAddress() );
        }
    }

}
