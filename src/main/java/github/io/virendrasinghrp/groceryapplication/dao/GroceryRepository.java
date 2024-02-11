package github.io.virendrasinghrp.groceryapplication.dao;

import github.io.virendrasinghrp.groceryapplication.entity.Grocery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends CrudRepository<Grocery, Integer> {
}