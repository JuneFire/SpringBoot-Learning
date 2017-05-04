package com.master.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 */
@Service(value = "userService")
public class UserService implements IUserService,UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;                // 用户仓库
    }


    @Override
    public User save(User entity) throws Exception {
        return userRepo.save(entity);
    }

    @Override
    public void delete(Long id) throws Exception {
        userRepo.delete(id);
    }

    @Override
    public void delete(User entity) throws Exception {
            userRepo.delete(entity);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findOne(id);
    }

    @Override
    public User findBySample(User sample) {
        return userRepo.findOne(whereSpec(sample));
    }

  /*  @Override
    public User findBySamples(String username,String password) {
        return userRepo.findUser(username,username);
    }*/

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findAll(User sample) {
        return userRepo.findAll(whereSpec(sample));
    }

    @Override
    public Page<User> findAll(PageRequest pageRequest) {
        return userRepo.findAll(pageRequest);
    }

    @Override
    public Page<User> findAll(User sample, PageRequest pageRequest) {
        return userRepo.findAll(whereSpec(sample),pageRequest);
    }

    private Specification<User> whereSpec(final User sample){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (sample.getId()!=null){
                predicates.add(cb.equal(root.<Long>get("id"), sample.getId()));
            }

            if (StringUtils.hasLength(sample.getUsername())){
                predicates.add(cb.equal(root.<String>get("username"),sample.getUsername()));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByUsername(username);

        if( user == null){
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }

        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();//GrantedAuthority是security提供的权限类，

        getRoles(user,list); //获取角色，放到list里面

        org.springframework.security.core.userdetails.User auth_user = new org.springframework.security.core.userdetails.User(
                user.getUsername(),user.getPassword(),list
        );//返回包括权限角色的User给security

        return auth_user ;
    }

    /**
     * 获取所属角色
     * @param user
     * @param list
     */
    public void getRoles(User user,List<GrantedAuthority> list){

        for (String role:user.getRole().split(",")) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role)); //权限如果前缀是ROLE_，security就会认为这是个角色信息，而不是权限，例如ROLE_MENBER就是MENBER角色，CAN_SEND就是CAN_SEND权限

        }

    }
}
