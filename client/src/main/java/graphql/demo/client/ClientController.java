package graphql.demo.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
public class ClientController {



    @RequestMapping("/")
    public String printMessage() {
        return "Hello world";
    }

    @RequestMapping("/listId")
    public String listEmployeesId() throws IOException {
        //GraphQLRequestBody rb = new GraphQLRequestBody();

        //final String variables = getSchemaFromFileName("variables");

        String query = "{\n" +
                "\"query\" : \"{ allEmployees{ id } }\"\n" +
                "}";

        // 创建httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post请求方式实例
        HttpPost httpPost = new HttpPost("http://localhost:8090/graphql");

        // 设置请求头 发送的是json数据格式
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        httpPost.setHeader("Connection", "Close");


        System.out.println(query);
        // 设置参数---设置消息实体 也就是携带的数据
        StringEntity entity = new StringEntity(
                query, Charset.forName("UTF-8"));
        // 设置编码格式
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        // 把请求消息实体塞进去
        httpPost.setEntity(entity);

        // 执行http的post请求
        CloseableHttpResponse httpResponse;
        String result = null;


        Instant inst1 = Instant.now();
        for(int i = 0; i < 100; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Instant inst2 = Instant.now();
        double diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 100:" + diff);

        inst1 = Instant.now();
        for(int i = 0; i < 200; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 200:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 300; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 300:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 400; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 400:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 500; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 500:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 600; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 600:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 700; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 700:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 800; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 800:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 900; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 900:" + diff);



        inst1 = Instant.now();
        for(int i = 0; i < 1000; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 1000:" + diff);

        return result;

    }

    @RequestMapping("/list")
    public String listEmployees() throws IOException {
        //GraphQLRequestBody rb = new GraphQLRequestBody();

        //final String variables = getSchemaFromFileName("variables");

        String query = "{\n" +
                "\"query\" : \"{ allEmployees{ id \\n firstName \\n lastName \\n salary \\n address \\n { \\n houseNo \\n country \\n city \\n street \\n state \\n }} }\"\n" +
                "}";

        // 创建httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post请求方式实例
        HttpPost httpPost = new HttpPost("http://localhost:8090/graphql");

        // 设置请求头 发送的是json数据格式
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        httpPost.setHeader("Connection", "Close");


        System.out.println(query);
        // 设置参数---设置消息实体 也就是携带的数据
        StringEntity entity = new StringEntity(
                query, Charset.forName("UTF-8"));
        // 设置编码格式
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        // 把请求消息实体塞进去
        httpPost.setEntity(entity);

        // 执行http的post请求
        CloseableHttpResponse httpResponse;
        String result = null;


        Instant inst1 = Instant.now();
        for(int i = 0; i < 100; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Instant inst2 = Instant.now();
        double diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 100:" + diff);

        inst1 = Instant.now();
        for(int i = 0; i < 200; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 200:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 300; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 300:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 400; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 400:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 500; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 500:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 600; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 600:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 700; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 700:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 800; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 800:" + diff);


        inst1 = Instant.now();
        for(int i = 0; i < 900; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 900:" + diff);



        inst1 = Instant.now();
        for(int i = 0; i < 1000; i ++){
            try {
                httpResponse = httpClient.execute(httpPost);
                result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inst2 = Instant.now();
        diff = Duration.between(inst1, inst2).toMillis();
        System.out.println("response time 1000:" + diff);

        return result;

    }

}
