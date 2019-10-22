/**
 * Copyright (c) reception  All rights reserved.
 *
 *
 *
 * 版权所有，侵权必究！
 */

package com.edgedo.common.util.oss.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 *
 * @author lsj
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
