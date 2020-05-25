package org.zyx.generator.serviceImpl;

import org.zyx.generator.entity.Student;
import org.zyx.generator.mapper.StudentMapper;
import org.zyx.generator.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
