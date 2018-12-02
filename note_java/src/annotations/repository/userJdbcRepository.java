package annotations.repository;

import org.springframework.stereotype.Service;

@Service
public class userJdbcRepository implements UserRespository {
    @Override
    public void save() {
        System.out.println("userJdbcRepository save ......");
    }
}
