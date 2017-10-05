package project.service;

import project.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDTO category);

    CategoryDTO getByLevelAndSourceIndex(int level, int sourceIndex);

    List<CategoryDTO> getListPreCategoriesBySourceIndex(int sourceIndex);

    CategoryDTO getByPageNameAndLevelAndSourceIndex(String pageName, int level, int sourceIndex);

    List<CategoryDTO> getListByLevel(int level);

    List<CategoryDTO> getSubCategories(int sourceIndex);

    CategoryDTO getByPageName(String pageName);

    List<CategoryDTO> getListInSameLevel(int sourceIndex);

    List<CategoryDTO> getListByPageNameList(List<String> pageNameList);
}
