package cn.moondust.auther.repository;

import cn.moondust.auther.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by j0 on 2016/7/29.
 */
public interface UserRepository extends JpaRepository<User, String>,JpaSpecificationExecutor<User> {
    User findOneByPhone(String phone);
}
