package com.xqd.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "b_user")
@ApiModel(value = "列表数据")
public class userBean {

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "id")
    @Id
    private int id;

    @ApiModelProperty(value = "幸运数字")
    @Column(name = "lucky_number")
    private Integer luckyNumber;

    public Integer getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(Integer luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}