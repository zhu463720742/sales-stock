package com.lichao.salesstock.business.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lichao.salesstock.business.model.Shop;

@Mapper
public interface ShopDao {

    @Select("select * from t_shop t where t.id = #{id}")
    Shop getById(Long id);

    @Delete("delete from t_shop where id = #{id}")
    int delete(Long id);

    int update(Shop shop);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_shop(shopName, shopAdress, userId, createTime) values(#{shopName}, #{shopAdress}, #{userId}, #{createTime})")
    int save(Shop shop);
    
    int count(@Param("params") Map<String, Object> params);

    List<Shop> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
