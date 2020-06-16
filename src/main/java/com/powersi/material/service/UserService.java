package com.powersi.material.service;

import com.powersi.material.mapper.RoleMapper;
import com.powersi.material.pojo.Employee;
import com.powersi.material.pojo.User;
import com.powersi.material.repository.EmployeeRepository;
import com.powersi.material.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleMapper roleMapper;

    private final RedisTemplate<String,Object> redisTemplate;

    //测试
    private final EmployeeRepository employ;

    /**
     * 审核用户是否可以登录
     * @param user  用户对象
     * @return      用户名与token的集合
     */
    public Map verify(User user) throws Exception{
        //判断用户是否为空
        Assert.notNull(user,"请求参数错误");
        //通过jpa来查询用户名字，返回该用户对象
        User rUser = userRepository.findByUsername(user.getUsername());
        //再次判断用户是否为空
        Assert.notNull(rUser,"用户不存在");
        //判断两个对象的密码是否一致
        if(!rUser.getPassword().equals(user.getPassword()))
            throw new Exception("密码错误");
        //通过用户的id获得用户的名字的集合
        Set<String> roles = roleMapper.findByUid(rUser.getUid());
        //设置用户的角色
        if(roles!=null && roles.size()>0) rUser.setRoles(roles);
        //设置密码为空
        rUser.setPassword(null);
        //设置用户的唯一标识token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //设置redis保存用户的信息
        redisTemplate.opsForValue().set(token,rUser,2*30*60,TimeUnit.SECONDS);
        //返回hash集合
        return new HashMap(){{
            put("username",rUser.getUsername());
            put("token", token);
        }};
    }

    /**
     * 审核用户是否可以登录
     * @param emp  职工对象
     * @return      职工名字与token的集合
     */
    public Map empLogin(Employee emp) throws Exception{

        //判断员工是否为空
        Assert.notNull(emp,"请求参数错误");

        Employee employee = employ.findByIdAndEmpTelp(emp.getId(),emp.getEmpTelp());

        //再次判断员工是否为空
        Assert.notNull(employee,"员工不存在");

        //判断两个员工的密码是否一致
        if(!employee.getEmpTelp().equals(emp.getEmpTelp()))
            throw new Exception("密码错误");

        //设置用户的唯一标识token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //设置redis保存用户的信息
        redisTemplate.opsForValue().set(token,employee,2*30*60,TimeUnit.SECONDS);

        return new HashMap(){{
//            put("id",employee.getId());
            put("empName",employee.getEmpName());
            put("token", token);
        }};

    }

    /**
     * 通过在redis中获取员工信息
     * @param token
     * @return
     */
    public Object getUserInfo(String token) {
        Object o = redisTemplate.opsForValue().get(token);
        if(o != null) redisTemplate.expire(token,2*30*60, TimeUnit.SECONDS);
        return o;
    }

    public String logout(String token) {
        redisTemplate.delete(token);
        return "ok";
    }
}
