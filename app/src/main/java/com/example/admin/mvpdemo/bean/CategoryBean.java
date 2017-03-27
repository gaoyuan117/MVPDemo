package com.example.admin.mvpdemo.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class CategoryBean {


    /**
     * id : 15
     * group : video
     * name : 推荐
     * cover_id : 0
     * sort : 0
     * create_time : 0
     * update_time : 0
     */

    private String id;
    private String group;
    private String name;
    private String cover_id;
    private String sort;
    private String create_time;
    private String update_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover_id() {
        return cover_id;
    }

    public void setCover_id(String cover_id) {
        this.cover_id = cover_id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

}
