package com.zhuang.limitless_android.bean;

/**
 * @Package     : com.zhuang.limitless_android.bean
 * @ClassName   : Plate 
 * @Description : 板块实体类
 * @author      : Zhuang
 * @date        : 2019-12-04 18:46
 */
public class Plate {

    public Plate() {
    }

    public Plate(String plateName) {
        this.plateName = plateName;
    }

    private Integer id;
    private String plateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "id=" + id +
                ", plateName='" + plateName + '\'' +
                '}';
    }
}
