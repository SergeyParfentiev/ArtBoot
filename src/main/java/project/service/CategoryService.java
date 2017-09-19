package project.service;

import project.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDTO category);

    CategoryDTO getCategoryByLevelSourceIndex(int level, int sourceIndex);

    CategoryDTO getCategoryByPageNameLevelSourceIndex(String pageName, int level, int sourceIndex);

    List<CategoryDTO> getCategoryListByLevel(int level);

    List<CategoryDTO> getSubCategories(int sourceIndex);
}
