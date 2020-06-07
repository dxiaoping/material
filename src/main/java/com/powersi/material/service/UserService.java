package com.powersi.material.service;

import com.powersi.material.mapper.RoleMapper;
import com.powersi.material.pojo.User;
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

    public Map verify(User user) throws Exception{
        Assert.notNull(user,"请求参数错误");
        User rUser = userRepository.findByUsername(user.getUsername());
        Assert.notNull(rUser,"用户不存在");
        if(!rUser.getPassword().equals(user.getPassword()))
            throw new Exception("密码错误");
        Set<String> roles = roleMapper.findByUid(rUser.getUid());
        if(roles!=null && roles.size()>0) rUser.setRoles(roles);
        rUser.setPassword(null);
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set(token,rUser,2*30*60,TimeUnit.SECONDS);
        return new HashMap(){{
            put("username",rUser.getUsername());
            put("token", token);
        }};
    }

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
