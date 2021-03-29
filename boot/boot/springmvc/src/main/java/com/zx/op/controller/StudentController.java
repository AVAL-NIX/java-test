package com.zx.op.controller;

import com.zx.framework.annotation.ZXAutowired;
import com.zx.framework.annotation.ZXController;
import com.zx.framework.annotation.ZXRequestMapping;
import com.zx.op.service.impl.StudentService;

/**
 * @author zhengxin
 * @date 2021/2/20
 */
@ZXRequestMapping("/student")
@ZXController
public class StudentController {

        @ZXAutowired
        StudentService studentService;

    /*    @ZXRequestMapping("/index")
        public String index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                            @ZXRequestParam("test") String str) throws IOException {
            httpServletResponse.getWriter().write("str : " + str + ", service : " + studentService.getStudentName());
            return str;
        }
*/

}
