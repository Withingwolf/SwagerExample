package com.withing.swagger;

import io.github.robwin.markup.builder.*;
import io.github.robwin.swagger2markup.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;
import springfox.documentation.staticdocs.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author huangweixin1@jd.com
 * create 2018/12/11 21:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SwaggerStaticDocTest {
    @Autowired
    private WebApplicationContext context;
    private String snippetDir = "target/generated-snippets";
    private String outputDir = "target/asciidoc";

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void Test() throws Exception {
        mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
                .andExpect(status().isOk())
                .andReturn();


        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withExamples(snippetDir)
                .build()
                .intoFolder(outputDir);
    }
}
