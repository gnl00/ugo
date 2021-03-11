package com.boot.ugo.entity.vo;

import com.boot.ugo.entity.Category;
import com.boot.ugo.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * TODO
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryGoodsVo {

    private Goods goods;
    private Category category;
    private List<String> picture;

}
