package org.zyx.generator.serviceImpl;

import org.zyx.generator.entity.User;
import org.zyx.generator.mapper.GUserMapper;
import org.zyx.generator.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刈剑丶
 * @since 2020-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<GUserMapper, User> implements UserService {

}
