package com.seata.order.dao;

import com.seata.order.entity.Order;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

@Repository
public interface OrderDao {
    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单金额
     */
     void update(@Param("userId") Long userId, @Param("status") Integer status);
}
