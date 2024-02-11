package github.io.virendrasinghrp.groceryapplication.controller;

import github.io.virendrasinghrp.groceryapplication.dto.GroceryDTO;
import github.io.virendrasinghrp.groceryapplication.dto.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Grocery API")
public interface GroceryController {
    @ApiOperation("Add new data")
    public GroceryDTO save(@RequestBody GroceryDTO grocery);

    @ApiOperation("Find by Id")
    public GroceryDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    public List<GroceryDTO> list();

    @ApiOperation("Update one data")
    public GroceryDTO update(@RequestBody GroceryDTO dto, @PathVariable("id") Integer id);

    @PutMapping("/admin/update-inventory/{id}/{count}")
    GroceryDTO updateInventory(@PathVariable("id") Integer id
            , @PathVariable("count") Integer count);

    @PostMapping("/user/order")
    @ResponseStatus(HttpStatus.CREATED)
    String order(@RequestBody List<Item> itemList) throws Exception;
}