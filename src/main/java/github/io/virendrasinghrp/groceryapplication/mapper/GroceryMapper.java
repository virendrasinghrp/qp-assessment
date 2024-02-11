package github.io.virendrasinghrp.groceryapplication.mapper;

import github.io.virendrasinghrp.groceryapplication.dto.GroceryDTO;
import github.io.virendrasinghrp.groceryapplication.entity.Grocery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroceryMapper {

    @Mapping(target = "id", ignore = false)
    Grocery asEntity(GroceryDTO dto);

    @Mapping(target = "id", ignore = false)
    GroceryDTO asDTO(Grocery entity);

    @Mapping(target = "id", ignore = false)
    List<Grocery> asEntityList(List<GroceryDTO> dtoList);

    @Mapping(target = "id", ignore = false)
    List<GroceryDTO> asDTOList(List<Grocery> entityList);
}