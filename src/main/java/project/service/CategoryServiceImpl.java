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
    public CategoryDTO getCategoryByLevelSourceIndex(int level, int sourceIndex) {
        return categoryRepository.getByLevelSourceIndex(level, sourceIndex);
    }

    @Override
    public CategoryDTO getCategoryByPageNameLevelSourceIndex(String pageName, int level, int sourceIndex) {
        return categoryRepository.getByPageNameLevelSourceIndex(pageName, level, sourceIndex);
    }

    @Override
    public List<CategoryDTO> getCategoryListByLevel(int level) {
        return categoryRepository.getListByLevel(level);
    }

    @Override
    public List<CategoryDTO> getSubCategories(int sourceIndex) {
        return categoryRepository.getSubCategories(sourceIndex);
    }
}
