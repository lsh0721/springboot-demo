/*
 * Author:   lishihui
 * FileName: CityInfoControllerTest
 * Date:     2019/12/24 15:38
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.springboot.demo.controller;

import com.springboot.demo.SpringbootDmoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @AUTHOR lishihui
 * @DATE 2019/12/24 15:38
 * @SEE [相关类/方法]（可选）
 * @SINCE [产品/模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDmoApplication.class)
@AutoConfigureMockMvc // 测试接口用
@WebAppConfiguration
@Slf4j
public class CityInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCityListTest() throws Exception {
        String url = "/city/cityList.do";
        String expectResult = "[{\"id\":1,\"name\":\"北京\",\"state\":\"BJ0001\",\"country\":\"CH01\"},{\"id\":2,\"name\":\"上海\",\"state\":\"SH0001\",\"country\":\"CH02\"},{\"id\":3,\"name\":\"广州\",\"state\":\"GD0001\",\"country\":\"CH03\"},{\"id\":4,\"name\":\"深圳\",\"state\":\"GD0002\",\"country\":\"CH04\"},{\"id\":5,\"name\":\"天津\",\"state\":\"TJ0001\",\"country\":\"CH05\"},{\"id\":6,\"name\":\"南京\",\"state\":\"JS0001\",\"country\":\"CH06\"},{\"id\":7,\"name\":\"杭州\",\"state\":\"ZJ0001\",\"country\":\"CH07\"},{\"id\":8,\"name\":\"苏州\",\"state\":\"JS0002\",\"country\":\"CH08\"},{\"id\":9,\"name\":\"武汉\",\"state\":\"HB0001\",\"country\":\"CH09\"},{\"id\":10,\"name\":\"成都\",\"state\":\"SC0001\",\"country\":\"CH10\"}]";
        //构造post请求参数
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(url);
        //mock请求
        ResultActions resultAction = mockMvc.perform(request);
        //获取响应 MockHttpServletResponse
        MockHttpServletResponse mockHttpServletResponse = resultAction.andReturn().getResponse();
        mockHttpServletResponse.setCharacterEncoding("UTF-8");
        //返回状态断言
        resultAction.andExpect(MockMvcResultMatchers.status().isOk())
                //返回结果断言
                .andExpect(MockMvcResultMatchers.content().string(expectResult));
        log.info("返回状态码status:{}", mockHttpServletResponse.getStatus());
        log.info("返回值:{}", mockHttpServletResponse.getContentAsString());
    }
}
