package github.io.virendrasinghrp.groceryapplication.controller.impl;

import github.io.virendrasinghrp.groceryapplication.controller.GroceryController;
import github.io.virendrasinghrp.groceryapplication.dto.GroceryDTO;
import github.io.virendrasinghrp.groceryapplication.dto.Item;
import github.io.virendrasinghrp.groceryapplication.entity.Grocery;
import github.io.virendrasinghrp.groceryapplication.mapper.GroceryMapper;
import github.io.virendrasinghrp.groceryapplication.service.GroceryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/grocery")
@RestController
public class GroceryControllerImpl implements GroceryController {
    private final GroceryServiceImpl groceryService;

    private final GroceryMapper groceryMapper;

    public GroceryControllerImpl(GroceryServiceImpl groceryService, GroceryMapper groceryMapper) {
        this.groceryService = groceryService;
        this.groceryMapper = groceryMapper;
    }

    @Override
    @PostMapping("/admin/save")
    @ResponseStatus(HttpStatus.CREATED)
    public GroceryDTO save(@RequestBody GroceryDTO groceryDTO) {
        Grocery grocery = groceryMapper.asEntity(groceryDTO);
        return groceryMapper.asDTO(groceryService.save(grocery));
    }

    @Override
    @GetMapping("/user/list/{id}")
    public GroceryDTO findById(@PathVariable("id") Integer id) {
        Grocery grocery = groceryService.findById(id).orElse(null);
        return groceryMapper.asDTO(grocery);
    }

    @Override
    @DeleteMapping("/admin/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        groceryService.deleteById(id);
    }

    @Override
    @GetMapping("/user/list/all")
    public List<GroceryDTO> list() {
        return groceryMapper.asDTOList(groceryService.findAll());
    }

    @Override
    @PutMapping("/admin/update/{id}")
    public GroceryDTO update(@RequestBody GroceryDTO groceryDTO, @PathVariable("id") Integer id) {
        Grocery grocery = groceryMapper.asEntity(groceryDTO);
        return groceryMapper.asDTO(groceryService.update(grocery, id));
    }

    @Override
    @PutMapping("/admin/update-inventory/{id}/{count}")
    public GroceryDTO updateInventory(@PathVariable("id") Integer id
            , @PathVariable("count") Integer count) {
        return groceryMapper.asDTO(groceryService.updateInventory(id, count));
    }

    @Override
    @PostMapping("/user/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String order(@RequestBody List<Item> itemList) throws Exception {
        return "Order Price is: " + groceryService.order(itemList);
    }

}