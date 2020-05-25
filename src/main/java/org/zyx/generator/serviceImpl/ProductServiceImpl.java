package org.zyx.generator.serviceImpl;

import org.zyx.generator.entity.Product;
import org.zyx.generator.mapper.ProductMapper;
import org.zyx.generator.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
