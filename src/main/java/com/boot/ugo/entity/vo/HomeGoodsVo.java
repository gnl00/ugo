package com.boot.ugo.entity.vo;

import com.boot.ugo.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * HomeGoodsVo
 *
 * @author gnl
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HomeGoodsVo {

    private Goods goods;
    private List<String> picture;

}
