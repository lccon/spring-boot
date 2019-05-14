package com.lc.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/5/14
 * @Author:lc
 */
public class Task implements Serializable {

    private Long id;
    private String name;
    private String taskGroup;
    private String description;
    private TaskPloy taskPloy;
    private String config;
    private String closed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPloy getTaskPloy() {
        return taskPloy;
    }

    public void setTaskPloy(TaskPloy taskPloy) {
        this.taskPloy = taskPloy;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }
}
