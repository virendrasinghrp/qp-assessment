package github.io.virendrasinghrp.groceryapplication.service;

import github.io.virendrasinghrp.groceryapplication.dao.GroceryRepository;
import github.io.virendrasinghrp.groceryapplication.dto.Item;
import github.io.virendrasinghrp.groceryapplication.entity.Grocery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroceryServiceImpl {
    private final GroceryRepository repository;

    public GroceryServiceImpl(GroceryRepository repository) {
        this.repository = repository;
    }

    public Grocery save(Grocery entity) {
        return repository.save(entity);
    }

    public List<Grocery> save(List<Grocery> entities) {
        return (List<Grocery>) repository.saveAll(entities);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Grocery> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Grocery> findAll() {
        return (List<Grocery>) repository.findAll();
    }

    public Grocery update(Grocery entity, Integer id) {
        Optional<Grocery> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    public Grocery updateInventory(Integer id, Integer count) {
        Optional<Grocery> optional = findById(id);
        if (optional.isPresent()) {
            Grocery entity = optional.get();
            entity.setInventory(count);
            return save(entity);
        }
        return null;
    }

    @Transactional(rollbackFor = { Exception.class })
    public Double order(List<Item> itemList) throws Exception {
        double orderPrice = 0;
        for(Item item : itemList) {
            Optional<Grocery> optional = findById(item.getId());
            if (optional.isPresent()) {
                Grocery entity = optional.get();
                Integer inventory = entity.getInventory();
                if (inventory >= item.getCount()) {
                    entity.setInventory(inventory - item.getCount());
                    orderPrice += entity.getPrice()* item.getCount();
                    save(entity);
                } else {
                    throw new Exception("Inventory not enough for item: " + item.getId()
                            + ". Available count is: " + entity.getInventory());
                }
            } else {
                throw new Exception("Following Id not present: " + item.getId());
            }

        }
        return orderPrice;
    }
}