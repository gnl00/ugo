package com.boot.ugo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Category 分类实体类
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer id;
    private String name;

    /**
     * 父级分类Id
     */
    private Integer parentId;

    /**
     * 分类级别
     */
    private Integer level;

}
