package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dto.CategoryDTO;
import project.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void addCategory(CategoryDTO category) {
        System.out.println("addCategory");
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getByLevelAndSourceIndex(int level, int sourceIndex) {
        return categoryRepository.getByLevelAndSourceIndex(level, sourceIndex);
    }

    @Override
    public List<CategoryDTO> getListPreCategoriesBySourceIndex(int sourceIndex) {
        return categoryRepository.getListPreCategoriesBySourceIndex(sourceIndex);
    }

    @Override
    public CategoryDTO getByPageNameAndLevelAndSourceIndex(String pageName, int level, int sourceIndex) {
        return categoryRepository.getByPageNameAndLevelAndSourceIndex(pageName, level, sourceIndex);
    }

    @Override
    public List<CategoryDTO> getListByLevel(int level) {
        return categoryRepository.getListByLevel(level);
    }

    @Override
    public List<CategoryDTO> getSubCategories(int sourceIndex) {
        return categoryRepository.getListSubCategories(sourceIndex);
    }

    @Override
    public CategoryDTO getByPageName(String pageName) {
        return categoryRepository.getByPageName(pageName);
    }

    @Override
    public List<CategoryDTO> getListInSameLevel(int sourceIndex) {
        return categoryRepository.getListInSameLevel(sourceIndex);
    }

    @Override
    public List<CategoryDTO> getListByPageNameList(List<String> pageNameList){
        return categoryRepository.getListByPageNameList(pageNameList);
    }
}
