package org.zyx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.zyx.entity.ProductVO;
import org.zyx.entity.User;

import java.util.List;

/**直接继承baseMapper,类似jpa,只需要继承接口即可直接使用
 * Created by SunShine on 2020/5/19.
 */
public interface UserMapper extends BaseMapper<User>{

    @Select("select p.*,u.name userName from product p,user u where p.user_id = u.id and u.id=#{id}")
    List<ProductVO> productVOList(Integer id);

}
