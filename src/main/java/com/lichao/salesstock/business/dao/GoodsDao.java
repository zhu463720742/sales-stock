package com.lichao.salesstock.business.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lichao.salesstock.business.model.Goods;

@Mapper
public interface GoodsDao {

    @Select("select * from t_goods t where t.id = #{id}")
    Goods getById(Long id);

    @Select("select * from t_goods t where t.goodsId = #{goodsId}")
    Goods getByGoodsId(String goodsId);

    @Delete("delete from t_goods where id = #{id}")
    int delete(Long id);

    int update(Goods goods);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_goods(goodsId, goodsName, goodsNorm, goodsAdress, goodsPrice, goodsNum, createTime) values(#{goodsId}, #{goodsName}, #{goodsNorm}, #{goodsAdress}, #{goodsPrice}, #{goodsNum}, #{createTime})")
    int save(Goods goods);
    
    int count(@Param("params") Map<String, Object> params);

    List<Goods> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
