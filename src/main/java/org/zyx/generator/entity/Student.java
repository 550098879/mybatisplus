package org.zyx.generator.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刈剑丶
 * @since 2020-05-25
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

      private Long sid;

    private String sname;

    private Integer cid;


}
