package WDM.mapper;

import WDM.pojo.Item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemMapper {
    @Update("update orderitem set amount = amount + 1 where itemid = #{itemId}")
    Boolean updateAmount(String itemId);

    @Select("select orderid, itemid, price, amount from orderitem where orderid = #{orderId}; ")
    List<Item> findItem(String orderId);

    ///orders/addItem/{order_id}/{item_id}
    //    POST - adds a given item in the order given
    //     need stock API stock/find/{id}
    @Insert("insert into orderitem(orderid, itemid, price) values(#{orderId}, #{itemId}, #{price}); ")
    Boolean addItem(String orderId, String itemId, double price);

    ///orders/removeItem/{order_id}/{item_id}
    //    DELETE - removes the given item from the given order
    @Delete("delete * from orderitem where orderid = #{orderId} and itemid = #{itemId};")
    Boolean removeItem(String orderId, String itemId);

}