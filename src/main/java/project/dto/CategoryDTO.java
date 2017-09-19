package project.dto;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "category")
public class CategoryDTO {

    public static final int FIRST_CATEGORY = 0;
    public static final int SECOND_CATEGORY = 1;
    public static final int THIRD_CATEGORY = 2;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pageName;

    @Column(nullable = false)
    private int level;

    @Column
    private int sourceIndex;

    @Column(nullable = false)
    private int index;

    @Column
    private String tool;

    @Transient
    private List<CategoryDTO> subCategoryList = new ArrayList<>();

    public CategoryDTO() {
    }

//    public CategoryDTO(String name, String pageName, int checky) {
//        this.name = name;
//        this.pageName = pageName;
//        this.checky = checky;
//    }

    public static int getCategoryNumber() {
        List<Integer> categories = new ArrayList<>();
        categories.add(FIRST_CATEGORY);
        categories.add(SECOND_CATEGORY);
        categories.add(THIRD_CATEGORY);
        return categories.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(int sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public List<CategoryDTO> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<CategoryDTO> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
