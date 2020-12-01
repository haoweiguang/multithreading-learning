package me.light.demo.consulclient;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.kv.model.GetValue;

/**
 * @author light.hao
 * @date 2020/9/27 1:28 下午
 */
public class ConsulMain {
    public static void main(String[] args) {
        String key = "light";
        ConsulClient client = new ConsulClient("localhost");
//        client.setKVValue(key, "light");

        Response<GetValue> keyValueResponse = client.getKVValue(key);
        Long currentIndex = keyValueResponse.getConsulIndex();
        System.out.println(currentIndex);
//        client.setKVValue(key, "new light");
        Response<GetValue> keyValueResponse1 = client.getKVValue(key);
        Long newIndex = keyValueResponse1.getConsulIndex();
        System.out.println(newIndex);

        String a = "";

    }
}
