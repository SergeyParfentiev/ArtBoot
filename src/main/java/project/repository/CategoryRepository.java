package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.dto.CategoryDTO;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryDTO, Long> {
    @Query("SELECT c FROM category c WHERE c.level = :level AND c.sourceIndex = :sourceIndex")
    CategoryDTO getByLevelSourceIndex(
            @Param("level") int level, @Param("sourceIndex") int sourceIndex);

    @Query("SELECT c FROM category c WHERE c.pageName = :pageName AND c.level = :level AND c.sourceIndex = :sourceIndex")
    CategoryDTO getByPageNameLevelSourceIndex(
            @Param("pageName") String pageName, @Param("level") int level, @Param("sourceIndex") int sourceIndex);

    @Query("SELECT c FROM category c WHERE c.level = :level")
    List<CategoryDTO> getListByLevel(@Param("level") int level);

    @Query("SELECT c FROM category c WHERE c.sourceIndex = :sourceIndex")
    List<CategoryDTO> getSubCategories(@Param("sourceIndex") int sourceIndex);
}
