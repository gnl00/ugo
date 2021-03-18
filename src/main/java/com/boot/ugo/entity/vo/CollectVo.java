package com.boot.ugo.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * CollectVo
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CollectVo {

    private Integer collectId;
    private Integer goodsId;
    private String goodsName;
    private BigDecimal price;
    private List<String> picture;

}
