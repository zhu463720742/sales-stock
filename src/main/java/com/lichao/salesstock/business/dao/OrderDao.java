package com.lichao.salesstock.business.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lichao.salesstock.business.model.Order;

@Mapper
public interface OrderDao {

    @Select("select * from t_order t where t.id = #{id}")
    Order getById(Long id);

    @Delete("delete from t_order where id = #{id}")
    int delete(Long id);

    int update(Order order);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_order(goodsId, goodsName, goodsNorm, goodsPrice, salePrice, goodsNum, totalPrices, mark, createTime, userId, shopId) values(#{goodsId}, #{goodsName}, #{goodsNorm}, #{goodsPrice}, #{salePrice}, #{goodsNum}, #{totalPrices}, #{mark}, #{createTime}, #{userId}, #{shopId})")
    int save(Order order);
    
    int count(@Param("params") Map<String, Object> params);

    List<Order> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
