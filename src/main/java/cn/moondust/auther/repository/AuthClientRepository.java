package cn.moondust.auther.repository;

import cn.moondust.auther.entity.AuthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by j0 on 2016/7/29.
 */
public interface AuthClientRepository extends JpaRepository<AuthClient, String>, JpaSpecificationExecutor<AuthClient> {
    AuthClient findOneByClientId(String client_id);

}
