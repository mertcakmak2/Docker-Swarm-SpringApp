package com.example.dockerizeapp.Service.User;

import com.example.dockerizeapp.Model.User;
import com.example.dockerizeapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @CacheEvict(cacheNames = "user_cache_list", allEntries = true)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Cacheable(cacheNames = "user_cache_list")
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
