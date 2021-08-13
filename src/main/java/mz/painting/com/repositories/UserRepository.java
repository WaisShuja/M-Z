package mz.painting.com.repositories;

import mz.painting.com.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Customer,Integer> {
}
