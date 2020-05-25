package org.zyx.generator.serviceImpl;

import org.zyx.generator.entity.TAccount;
import org.zyx.generator.mapper.TAccountMapper;
import org.zyx.generator.service.TAccountService;
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
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService {

}
